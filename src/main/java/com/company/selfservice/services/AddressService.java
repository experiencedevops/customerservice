package com.company.selfservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.selfservice.domain.Address;
import com.company.selfservice.repo.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	public Address getAddress(Integer id){
		if(this.addressRepository.exists(id)){
			return this.addressRepository.findOne(id);
		}
		return null;
	}
	
	public Address createAddress(String line1,String line2,String county,String country,String postcode){
		return addressRepository.save(new Address(line1, line2, county, country, postcode));
	}
	
	public Address updateAddress(Address address){
		return addressRepository.save(address);
	}

}
