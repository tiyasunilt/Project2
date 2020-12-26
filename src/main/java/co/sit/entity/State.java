package co.sit.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "STATE_TBL")
public class State {
 @Id
 @GeneratedValue
 @Column(name = "STATE_ID")
 private Integer stateId;
 
 @Column(name = "COUNTRY_ID")
 private Integer countryId;
 
 @Column(name = "STATE_NAME")
 private String stateName;
}
