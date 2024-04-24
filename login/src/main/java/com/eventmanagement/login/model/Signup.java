package com.eventmanagement.login.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Signup {
    @Id
    private String emailId;
    private String userName;
    private String password;
    private String dob;

    @OneToOne(mappedBy = "signup", cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Event event;
}
