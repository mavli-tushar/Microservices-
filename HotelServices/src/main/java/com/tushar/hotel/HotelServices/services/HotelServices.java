package com.tushar.hotel.HotelServices.services;

import com.tushar.hotel.HotelServices.HotelServicesApplication;
import com.tushar.hotel.HotelServices.exception.ResourceNotFoundException;
import com.tushar.hotel.HotelServices.model.Hotel;
import com.tushar.hotel.HotelServices.reposetory.HotelRepo;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServices {
    @Autowired
    private HotelRepo hotelRepo;

    public Hotel createHotel(Hotel hotel){
        String hotelId= UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepo.save(hotel);
    }
    public List<Hotel>getAll(){
        return hotelRepo.findAll();
    }
    public Hotel getHotelById(String id){
        return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel is not found:"+id));
    }
}
