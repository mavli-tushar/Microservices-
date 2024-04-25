package com.tushar.user.services.UserServices;

import com.tushar.user.services.UserServices.externerServices.RatingServices;
import com.tushar.user.services.UserServices.model.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServicesApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//	private RatingServices ratingServices;
//	@Test
//	void createRating(){
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("this is demo created from feign client").build();
//		Rating rating1 = ratingServices.createRating(rating);
//		System.out.println("new rating created ");
//	}

}
