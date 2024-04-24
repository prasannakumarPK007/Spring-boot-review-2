package com.eventmanagement.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eventmanagement.login.model.Signup;

@Repository
public interface SignRepo extends JpaRepository<Signup, String> {

    @Query("select u from Signup u where u.emailId=?1")
    Signup findByEmailId(String emailId);

    Signup findByEmailIdAndPassword(String emailId, String password);

}