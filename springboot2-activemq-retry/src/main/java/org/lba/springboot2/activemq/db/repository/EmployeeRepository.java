package org.lba.springboot2.activemq.db.repository;

import java.math.BigDecimal;

import org.lba.springboot2.activemq.db.model.EmployeeDBModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeRepository extends JpaRepository<EmployeeDBModel, BigDecimal>, JpaSpecificationExecutor<EmployeeDBModel>{

}
