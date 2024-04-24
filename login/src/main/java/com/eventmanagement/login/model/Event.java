package com.eventmanagement.login.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

// import org.hibernate.annotations.ManyToAny;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event {
    @Id
    private int packageid;
    private String foods;
    private String desserts;
    private int members;
    private int packageprice;

    @OneToOne
    private Signup signup;

    @ManyToOne
    @JsonBackReference
    private Client client;
}
