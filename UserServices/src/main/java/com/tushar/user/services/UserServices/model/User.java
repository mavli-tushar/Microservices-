package com.tushar.user.services.UserServices.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "micro_user")
public class User {
    @Id
    private String userId;
    @Column(length = 20)
    private String name;
    private  String about;
    private String email;

    @Transient
    private List<Rating> ratings =new ArrayList<>();
}
