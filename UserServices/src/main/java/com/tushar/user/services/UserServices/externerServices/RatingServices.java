package com.tushar.user.services.UserServices.externerServices;

import com.tushar.user.services.UserServices.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;

@FeignClient(name = "RATINGSERVICES")
public interface RatingServices {

    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    @PutMapping("/ratings/{id}")
    public Rating updateRating(@PathVariable("id") String id, Rating values);
    @DeleteMapping("/ratings/{id}")
    public void deleteRating(@PathVariable String id);


}
