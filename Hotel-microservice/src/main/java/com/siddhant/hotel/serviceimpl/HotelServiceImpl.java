package com.siddhant.hotel.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhant.hotel.entity.Hotel;
import com.siddhant.hotel.exception.ResourceNotFoundException;
import com.siddhant.hotel.repository.HotelRepository;
import com.siddhant.hotel.service.HotelService;


@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelrepo;
	
	
	@Override
	public Hotel savehotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelrepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllhotels() {
		// TODO Auto-generated method stub
		return hotelrepo.findAll();
	}

	@Override
	public Hotel getHotelById(String Id) {
		return hotelrepo.findById(Id).orElseThrow(()->new ResourceNotFoundException());
	}

	@Override
	public Hotel updateHotelDetails(String Id, Hotel hotel) {
		Hotel existinghotel = hotelrepo.findById(Id).orElseThrow(()->new ResourceNotFoundException());
		existinghotel.setName(hotel.getName());
		existinghotel.setLocation(hotel.getLocation());
		existinghotel.setAbout(hotel.getAbout());
		
		
		return hotelrepo.save(existinghotel);
	}

//	@Override
//	public String deleteHotel(String Id) {
//		hotelrepo.deleteById(Id);
//		return "Hotel Detail Deleted Successfully!!";
//	}

}
