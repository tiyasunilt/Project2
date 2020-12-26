package co.sit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USERS_TBL")
public class User {
 @Id
 @GeneratedValue
 @Column(name = "USER_ID")
 private Integer userId;
 
 @Column(name = "FIRSTNAME")
 private String firstName;
 
 @Column(name = "LASTNAME")
 private String lastName;
 
 @Column(name = "EMAIL")
 private String email;
 
 @Column(name = "PASSWORD")
 private String password;
 
 @Column(name = "PHONENO")
 private Long phoneNumber;
 
 @Column(name = "DOB")
 private Date dob;
 
 @Column(name = "GENDER")
 private Character gender;
 
 @Column(name = "COUNTRY")
 private String country;
 
 @Column(name = "STATE")
 private String state;
 
 @Column(name = "CITY")
 private String city;
 
 @Column(name = "IS_LOCKED")
 private Character isLocked;
}

