package com.tushar.user.services.UserServices.reposetory;

import com.tushar.user.services.UserServices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {

}
