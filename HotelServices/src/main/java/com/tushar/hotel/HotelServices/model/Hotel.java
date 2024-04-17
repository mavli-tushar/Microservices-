package com.tushar.hotel.HotelServices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotel {
    @Id
    private String hotelId;
    private String name;
    private String location;
    private String about;

}
