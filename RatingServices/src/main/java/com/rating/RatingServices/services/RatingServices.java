package com.rating.RatingServices.services;

import com.rating.RatingServices.model.Rating;
import com.rating.RatingServices.reposetory.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServices {
    @Autowired
    private RatingRepo ratingRepo;

    public Rating create(Rating rating){
        return  ratingRepo.save(rating);
    }
    public List<Rating> getAllReting(){
        return ratingRepo.findAll();
    }

    public List<Rating> getRatingByUserId(String userId){
        return ratingRepo.findByUserId(userId);
    }
    public List<Rating> getRatingByHotelId(String hotelId){
        return ratingRepo.findByHotelId(hotelId);
    }
}
