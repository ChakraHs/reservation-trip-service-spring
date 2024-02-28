package com.services.reservationtripservice.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.services.reservationtripservice.dao.TripReservationDao;
import com.services.reservationtripservice.dto.TripReservationDto;
import com.services.reservationtripservice.models.TourismTripsEntity;
import com.services.reservationtripservice.models.TripReservationEntity;
import com.services.reservationtripservice.models.UserEntity;
import com.services.reservationtripservice.services.facade.TripReservationService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class TripReservationServiceImpl implements TripReservationService {


		private TripReservationDao tripReservationDao;
		private ModelMapper modelMapper;
		
		@Override
		public List<TripReservationDto> findAll() {
			
			return tripReservationDao
					.findAll()
					.stream().map( el->modelMapper.map(el, TripReservationDto.class) )
					.collect(Collectors.toList())
					;
			
		}

		@Override
		public TripReservationDto save(TripReservationDto tripReservationDto) {
			
//			TripReservationDto tripReservationSaved = tripReservationService.save(tripReservationDto);
			
			TripReservationEntity tripReservationEntity = modelMapper.map(tripReservationDto, TripReservationEntity.class);
			
			UserEntity userEntity = new UserEntity();
			userEntity.setUserId(tripReservationDto.getUser());
			tripReservationEntity.setUser(userEntity);
			
			TourismTripsEntity tourismTripsEntity = new TourismTripsEntity();
			tourismTripsEntity.setTripId(tripReservationDto.getTripId());
			tripReservationEntity.setTrip(tourismTripsEntity);
			
			
			
			TripReservationEntity saved = tripReservationDao.save(tripReservationEntity);
			
			return modelMapper.map(saved, TripReservationDto.class);
		}

		@Override
		public TripReservationDto update(TripReservationDto tripReservationDto, Integer id) throws NotFoundException {

			Optional<TripReservationEntity> optional = tripReservationDao.findById(id);
			
			if(optional.isPresent()) {
				
				
				TripReservationEntity tripReservationEntity = modelMapper.map(tripReservationDto, TripReservationEntity.class);
				
				tripReservationEntity.setReservationId(id);
				
				TripReservationEntity updated = tripReservationDao.save(tripReservationEntity);
				return modelMapper.map(updated, TripReservationDto.class);
				
			}else {
				throw new EntityNotFoundException("Trip Not found");
			}
		}

		@Override
		public TripReservationDto findById(Integer id) {

			TripReservationEntity tripReservationEntity = tripReservationDao.findById(id).orElseThrow( ()->new EntityNotFoundException("Trip Not Found"));
			
			return modelMapper.map(tripReservationEntity , TripReservationDto.class);
		}

		@Override
		public void delete(Integer id) {
			
			TripReservationEntity tripReservationEntity = tripReservationDao.findById(id).orElseThrow( ()->new EntityNotFoundException("Trip Not Found"));
			tripReservationDao.delete(tripReservationEntity);
			
	}
}
