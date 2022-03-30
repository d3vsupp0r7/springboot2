package org.lba.springboot2.mybatis.doubleds.db.repository;

import java.util.Optional;

import org.lba.springboot2.mybatis.doubleds.db.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{

	Optional<EmployeeModel> findById(Long id);

	EmployeeModel findByName(String name);


}