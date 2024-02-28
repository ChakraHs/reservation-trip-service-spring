package com.services.reservationtripservice.controllers;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.reservationtripservice.dto.TripReservationDto;
import com.services.reservationtripservice.services.facade.TripReservationService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("trips")
@AllArgsConstructor
public class TripReservationController {

	private TripReservationService tripReservationService;
	
	@GetMapping("")
	public ResponseEntity<List<TripReservationDto>> findAll(){
			return new ResponseEntity<>(tripReservationService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<TripReservationDto> save( @Valid @RequestBody() TripReservationDto tripReservationDto){
		
		TripReservationDto saved = tripReservationService.save(tripReservationDto);
		return ResponseEntity.accepted().body(saved);
		
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<TripReservationDto> update(@Valid @RequestBody TripReservationDto tripReservationDto, @PathVariable Integer id) throws NotFoundException {

		TripReservationDto updated = tripReservationService.update(tripReservationDto, id);
		return ResponseEntity.accepted().body(updated);
	}
	
	@GetMapping("/id/{id}")
    public ResponseEntity<TripReservationDto> findById( @PathVariable("id") Integer id) {
		TripReservationDto tripReservationDto = tripReservationService.findById(id);
    	return ResponseEntity.ok(tripReservationDto);
    }
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> delete( @PathVariable("id") Integer id) {
		tripReservationService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
