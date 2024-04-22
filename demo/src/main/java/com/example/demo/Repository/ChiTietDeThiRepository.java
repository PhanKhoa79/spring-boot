package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ChiTietDeThi;

import jakarta.transaction.Transactional;

@Repository
public interface ChiTietDeThiRepository extends JpaRepository<ChiTietDeThi, Integer>{
	@Transactional
	public void deleteByIdDeThi(String idDeThi);
	
	public List<ChiTietDeThi> findByIdDeThi(String idDeThi);
}
