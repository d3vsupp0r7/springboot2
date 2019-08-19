package org.lba.springboot2.db.repository;

import java.util.Optional;

import org.lba.springboot2.db.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Optional<Employee> findById(Long id);

	Employee findByName(String name);


}