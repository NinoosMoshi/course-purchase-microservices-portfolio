package com.ninos.apigatewaymicroservice3.repository;

import com.ninos.apigatewaymicroservice3.model.Role;
import com.ninos.apigatewaymicroservice3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);


    // HQL Query
    @Modifying
    @Query("update User set role = :role where username = :username")
    void updateUserRole(@Param ("username") String username, @Param("role") Role role);

//    Native-Query with JPA Query annotation:
//    @Modifying
//    @Query(value = "update User u set u.role = :role where u.username = :username", nativeQuery=true)
//    void updateUserRole(@Param("username") String username, @Param("role") Role role);


}
