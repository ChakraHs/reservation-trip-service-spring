package com.services.reservationtripservice.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table( name = "guide_reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GuideReservationEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	Integer reservationId;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_reservation", nullable = false, updatable = false)
	Date dateReservation;
	
	@ManyToOne()
	@JoinColumn(name = "user_id" )
	UserEntity user;
	
	@ManyToOne()
	@JoinColumn(name = "guide_id" )
	GuideEntity guide;
	
	@ManyToMany
	@JoinTable(
			name="reservation_place",
			joinColumns = @JoinColumn(name="reservation_id"),
			inverseJoinColumns = @JoinColumn(name="place_id")
		)
	List<PlacesEntity> places;
	
}
