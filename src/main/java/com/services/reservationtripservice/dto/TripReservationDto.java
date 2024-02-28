package com.services.reservationtripservice.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripReservationDto{

	/**
	 * 
	 */
	
	Integer reservationId;
	
	Date dateReservation;
	
	Integer user;
	
	Integer tripId;
	
}

