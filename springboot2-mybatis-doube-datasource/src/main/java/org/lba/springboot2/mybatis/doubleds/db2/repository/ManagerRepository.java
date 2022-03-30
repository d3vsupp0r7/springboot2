package org.lba.springboot2.mybatis.doubleds.db2.repository;

import java.util.Optional;

import org.lba.springboot2.mybatis.doubleds.db2.model.ManagerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerModel, Long>{

	Optional<ManagerModel> findById(Long id);

	ManagerModel findByName(String name);


}