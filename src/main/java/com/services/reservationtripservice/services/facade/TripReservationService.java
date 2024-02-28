package com.services.reservationtripservice.services.facade;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.services.reservationtripservice.dto.TripReservationDto;

public interface TripReservationService {
	
	List<TripReservationDto> findAll();
	
	TripReservationDto save( TripReservationDto tripReservationDto );
	
	TripReservationDto update( TripReservationDto tripReservationDto , Integer id ) throws NotFoundException;
	
	TripReservationDto findById( Integer id );
	
	void delete( Integer id );
}
