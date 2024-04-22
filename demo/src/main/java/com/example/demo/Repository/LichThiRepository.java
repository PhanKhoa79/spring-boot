package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.LichThi;

@Repository
public interface LichThiRepository extends JpaRepository<LichThi, Integer>{
	public List<LichThi> findByIdMonThi(String idMonThi);
}
