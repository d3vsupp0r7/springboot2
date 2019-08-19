package org.lba.springboot2.db.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.lba.springboot2.db.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Optional<Employee> findById(Long id);

	Employee findByName(String name);
	
	//Update
	@Modifying
	@Transactional
	@Query("update Employee e set e.name = :name, e.surname = :surname where e.id= :id")
	int updateEmplyeeById(@Param("name") String name, @Param("surname") String surname, @Param("id") Long id);
	

}