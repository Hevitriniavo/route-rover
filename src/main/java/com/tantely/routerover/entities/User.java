package com.tantely.routerover.entities;

import com.tantely.routerover.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class User extends Model implements Serializable {

    private String lastName;

    private String firstName;

    private String password;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String driverLicense;

    @Column(unique = true)
    private String email;

    private String photo;

    @Column(columnDefinition = "TEXT")
    private String token;


    @ManyToOne
    private Place place;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();


    @OneToMany(mappedBy = "driver")
    private List<Transport> transportsAsDriver = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Transport> transportsAsCustomer = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations = new ArrayList<>();

}
