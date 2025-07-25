package com.girdhari.association.Entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TABLE")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer userid;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Order order;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_EMAIL")
    private String email;

    @Column(name = "USER_PHONE_NO")
    private Long phoneno;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "USER_CREATION_DATE", updatable = false)
    private Date creationdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTH_ID")
    @JsonManagedReference
    private Auth auth;

}
