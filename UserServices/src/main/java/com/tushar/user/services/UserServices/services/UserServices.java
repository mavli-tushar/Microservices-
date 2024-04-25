package com.tushar.user.services.UserServices.services;

import com.tushar.user.services.UserServices.exception.ResourceNotFoundException;
import com.tushar.user.services.UserServices.externerServices.HotelServices;
import com.tushar.user.services.UserServices.model.Hotel;
import com.tushar.user.services.UserServices.model.Rating;
import com.tushar.user.services.UserServices.model.User;
import com.tushar.user.services.UserServices.reposetory.UserRepo;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserServices {
    @Autowired
    private RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(UserServices.class);
    @Autowired
    private HotelServices hotelServices;
    @Autowired
    private UserRepo userRepo;
    public User saveUser(User user){
        String s = UUID.randomUUID().toString();
        user.setUserId(s);
        return userRepo.save(user);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    //get single user

    public User getUserById(String userId) {
        // Get user from database with user repository
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found: " + userId));

        // Get ratings of this user from the ratings service
        List<Rating> ratingOfUsers = restTemplate.exchange("http://RATING-SERVICES/ratings/user/" + user.getUserId(),
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Rating>>() {}).getBody();
        logger.info("{}", ratingOfUsers);

        // Fetch hotel information for each rating
        List<Rating> ratingList = ratingOfUsers.stream().map(rating -> {
            try {
                // Call the hotel API to get hotel information
//                ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICES/hotels/" + rating.getHotelId(), Hotel.class);
                Hotel hotel = hotelServices.getHotel(rating.getHotelId());
//                logger.info("response status code: {}", forEntity.getStatusCode());

                // Set the hotel information to the rating
                rating.setHotel(hotel);
            } catch (Exception e) {
                logger.error("Error fetching hotel information for rating: {}", rating.getRateId(), e);
            }
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }


}
