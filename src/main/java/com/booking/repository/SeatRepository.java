package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer>{

}
