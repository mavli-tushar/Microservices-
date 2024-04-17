package com.tushar.user.services.UserServices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rating {
    private String rateId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
