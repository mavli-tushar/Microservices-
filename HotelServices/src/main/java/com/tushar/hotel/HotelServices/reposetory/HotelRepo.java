package com.tushar.hotel.HotelServices.reposetory;

import com.tushar.hotel.HotelServices.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,String> {

}
