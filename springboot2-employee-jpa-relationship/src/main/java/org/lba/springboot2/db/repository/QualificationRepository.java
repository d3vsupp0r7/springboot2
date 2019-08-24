package org.lba.springboot2.db.repository;

import java.util.Optional;

import org.lba.springboot2.db.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long>{

	Optional<Qualification> findById(Long id);

	Qualification findByQualification(String qualification);
	
	

}