package com.siddhant.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siddhant.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
