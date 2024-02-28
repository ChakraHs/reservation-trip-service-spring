package com.services.reservationtripservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.services.reservationtripservice.models.TripReservationEntity;

@Repository

public interface TripReservationDao extends JpaRepository<TripReservationEntity, Integer>{
	
}
