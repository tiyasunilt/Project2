package co.sit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CITY_TBL")
public class City {
 @Id
 @GeneratedValue
 @Column(name = "CITY_ID")
 private Integer cityId;
 
 @Column(name = "STATE_ID")
 private Integer stateId;
 
 @Column(name = "CITY_NAME")
 private String cityName;
}