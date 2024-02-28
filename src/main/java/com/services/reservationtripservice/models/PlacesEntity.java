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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table( name = "places")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlacesEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "place_id")
	Integer placeId;
	
	@Column( nullable = false )
	String name;
	
	@Column( nullable = false )
	String description;
	
	@Column( nullable = false )
	float latitude;
	
	@Column( nullable = false )
	float longitude;
	
	@Column( nullable = false )
	String ville;
	
	@ManyToMany
	@JoinTable(
			name="reservation_place",
			joinColumns = @JoinColumn(name="place_id"),
			inverseJoinColumns = @JoinColumn(name="reservation_id")
		)
	List<GuideReservationEntity> guideReservation;
	
	@OneToMany(mappedBy = "place" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	List<ImagePlaceEntity> images;
	
	@OneToMany(mappedBy = "place" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	List<RatingPlaceEntity> ratingPlaceEntities ; 
	
}
