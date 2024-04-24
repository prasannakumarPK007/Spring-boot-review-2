package com.eventmanagement.login.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    private int clientId;
    private String companyName;
    private String clientName;

    private int totalbudget;
    private String email;
    private String phNo;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "client")
    @JsonBackReference
    private List<Event> event;

}
