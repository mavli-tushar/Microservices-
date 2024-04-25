package com.tushar.user.services.UserServices.externerServices;

import com.tushar.user.services.UserServices.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICES")
public interface HotelServices {
    @GetMapping("/hotels/{id}")
    Hotel getHotel(@PathVariable("id") String id);
}
