package com.services.reservationtripservice.models;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table( name = "restaurants")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	Integer restaurantId;
	
	@Column( nullable = false )
	String title;
	
	@Column( nullable = false )
	String food_category;
	
	@Column( nullable = false )
	String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column( nullable = false , name = "opening_date" , updatable = false)
	Date openingDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column( nullable = false , name = "closing_date" , updatable = false)
	Date closingDate;
	
	@OneToMany(mappedBy = "restaurant" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	List<ImageRestaurantEntity> images;
	
	@OneToMany(mappedBy = "restaurant" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	List<RatingRestaurantEntity> ratingRestaurantEntities ;
	
}
