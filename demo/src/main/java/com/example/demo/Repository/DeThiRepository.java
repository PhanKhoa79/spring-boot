package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.DeThi;

@Repository
public interface DeThiRepository extends JpaRepository<DeThi, String>{
	public List<DeThi> findByIdMonThi(String idMonThi); 
}
