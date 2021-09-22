package com.brs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.brs.entity.Bus;
import com.brs.entity.Reservation;
import com.brs.entity.User;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.service.IReservationService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@SpringBootTest
class ReservationServiceTest {

	@Autowired
	IReservationService reservationService;
	
	@Test

	void testAddReservation() { 
		LocalDate date=LocalDate.now();
		LocalTime time=LocalTime.now();
		Bus bus1=new Bus(1,"busname","drivername","bustype","routefrom","routeto",time,time,3,2);
		User user1=new User(1,"raj","password","fname","lastname","979104561","abc@gmail.com");
		Reservation reservation=new Reservation(1,"accepted","cornerseat", date, time,"chennai","delhi",bus1,user1);		
		Reservation persistedReservation=reservationService.addReservation(reservation);
		assertEquals("cornerseat",persistedReservation.getReservationType());
		assertEquals("accepted",persistedReservation.getReservationStatus());
		
		
	}
	
	@Test
	
	void testUpdateReservation() {
		LocalDate date=LocalDate.now();
		LocalTime time=LocalTime.now();
		Bus bus1=new Bus(1,"busname","drivername","bustype","routefrom","routeto",time,time,3,2);
		User user1=new User(1,"raj","password","fname","lastname","979104561","abc@gmail.com");
		
		Reservation reservation=new Reservation(1,"accepted","cornerseat", date, time,"chennai","delhi",bus1,user1);
						
		Reservation updated=reservationService.updateReservation(reservation);
		System.out.println(updated);
		assertEquals("accepted", updated.getReservationStatus());
	}
	
	
	@Test
	void testviewAllReservation() {
		List<Reservation> reservation = reservationService.viewAllReservation();
		int size=reservation.size();
		assertEquals(size, reservation.size());
		
	}
	
	@Test
	void testviewReservation() throws ReservationNotFoundException {
		Reservation reservation = reservationService.viewReservation(1);
		assertEquals("accepted",reservation.getReservationStatus());
		
	}

}