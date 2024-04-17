package com.rating.RatingServices.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Document("user_ratings")
public class Rating {
    @Id
    private String rateId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
