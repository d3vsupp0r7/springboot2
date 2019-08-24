package org.lba.springboot2.db.repository;

import java.util.Optional;

import org.lba.springboot2.db.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Optional<Department> findById(Long id);

	Department findByName(String name);
	
	

}