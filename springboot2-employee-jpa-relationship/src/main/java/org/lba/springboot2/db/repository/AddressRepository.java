package org.lba.springboot2.db.repository;

import java.util.Optional;

import org.lba.springboot2.db.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	Optional<Address> findById(Long id);

	Address findByStreet(String street);
	
	

}