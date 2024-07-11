package springBoot.userManagement.springbootrestfulwebservices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//make it as a JPA entity, which represents a table in MySQL database
@Entity

//We are using this annotation to give name the database , without this JPA will give the table as class Name by default
@Table(name = "users")
public class User {
    //instance variable i.e. class level variable

    //making primary key for the table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;


    @Column(nullable = false)
    private String lastName;


    @Column(nullable = false , unique = true)
    private String email;
}
