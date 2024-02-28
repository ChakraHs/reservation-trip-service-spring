package com.services.reservationtripservice.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table( name = "users" , uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	Integer userId;
	
	@Column( nullable = false , unique = true )
	String email;
	
	@Column( nullable = false )
	String password;
	
	@Column( nullable = false )
	String name;
	
	@Column( nullable = false )
	String lastName;
	
	@Column( nullable = false )
	String Country;
	
	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	List<TripReservationEntity> tripsReservation ;
	
	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	List<GuideReservationEntity> guidesReservation ;

	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	List<RatingPlaceEntity> ratingPlace;
	
	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	List<RatingRestaurantEntity> ratingRestaurant;
	
	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	List<RatingTripEntity> ratingTrip;
	
}
