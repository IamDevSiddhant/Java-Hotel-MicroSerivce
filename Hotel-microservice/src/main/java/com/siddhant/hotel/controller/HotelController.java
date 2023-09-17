package com.siddhant.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.siddhant.hotel.entity.Hotel;
import com.siddhant.hotel.repository.HotelRepository;
import com.siddhant.hotel.serviceimpl.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	@Autowired
	private HotelRepository hotelrepo;
	
	@PostMapping("/savehotel")
	public ResponseEntity<Hotel> savehotel(@RequestBody Hotel hotel) {
		
		Hotel samplehotel = hotelServiceImpl.savehotel(hotel);
		
		return new ResponseEntity<Hotel>(samplehotel,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getallhotels")
	public ResponseEntity<List<Hotel>> getListofHotels (){
		List<Hotel> getallhotels = hotelServiceImpl.getAllhotels();
		return new ResponseEntity<List<Hotel>>(getallhotels,HttpStatus.OK);
	} 
	
	@GetMapping("/gethotel/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id){
		Hotel hotel = hotelServiceImpl.getHotelById(id);
		return new ResponseEntity<Hotel>(hotel,HttpStatus.OK);
	}
	
	@PutMapping("/updatehotel/{id}")
	public ResponseEntity<Hotel> updateHotel (@PathVariable String id, @RequestBody Hotel hotel){
		Hotel updatehotel = hotelServiceImpl.updateHotelDetails(id, hotel);
		return new ResponseEntity<Hotel>(updatehotel,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletehotel/{id}")
	public ResponseEntity<Map<String,String>> deletehotel(@PathVariable String id) {
		hotelrepo.deleteById(id);
		Map map = new HashMap<>();
		map.put("Message", "Hotel Detail Deleted Successfully!!");
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
	}
	
}
