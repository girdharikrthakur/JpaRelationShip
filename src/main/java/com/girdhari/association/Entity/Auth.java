package com.girdhari.association.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "USER_AUTH")
@NoArgsConstructor
@AllArgsConstructor
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTH_ID")
    private Integer authid;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "USER_PASSWORD")
    private String password;

    @OneToOne(mappedBy = "auth")
    @JsonBackReference
    private User user;

}
