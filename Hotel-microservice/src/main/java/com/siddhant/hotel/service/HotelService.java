package com.siddhant.hotel.service;

import java.util.List;
import java.util.Map;

import com.siddhant.hotel.entity.Hotel;

public interface HotelService {

	Hotel savehotel(Hotel hotel);
	
	List<Hotel> getAllhotels();
	
	Hotel getHotelById (String Id);
	
	Hotel updateHotelDetails(String Id, Hotel hotel);
	
	//String deleteHotel(String Id);
	
}
