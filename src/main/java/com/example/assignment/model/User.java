package com.example.assignment.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "name cannot be null")
    private String name;
    private int age;
    @NotNull(message = "email cannot be null")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "email should be in format abc@xyz.com")
    private String email;
    @NotNull(message = "contact cannot be null")
    @Pattern(regexp = "^\\+91 [0-9]{10}$",message = "contact number should include country code +91 followed by a space and " +
            "10 digit mobile number ")
    private String contact;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
}
