package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.MonThi;

@Repository
public interface MonThiRepository extends JpaRepository<MonThi, String>{

	@Query("SELECT mt.idMonThi FROM MonThi mt WHERE mt.tenMonThi = :tenMonThi")
	String findIdMonThiByTenMonThi(@Param("tenMonThi") String tenMonThi);
	
}
