package com.services.reservationtripservice.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table( name = "rating_restaurant" )
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RatingRestaurantEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rating_id")
	Integer ratingId;
	
	@Column( nullable = false )
	Integer number;
	
	@Column( nullable = false )
	String description;
	
	@ManyToOne()
	@JoinColumn(name = "user_id" )
	UserEntity user;
	
	@ManyToOne()
	@JoinColumn(name = "restaurant_id" )
	RestaurantEntity restaurant;

	
}
