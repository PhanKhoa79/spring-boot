package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Lop;

@Repository
public interface LopRepository extends JpaRepository<Lop, String>{
	public List<Lop> findByKhoa_IdKhoa(String idKhoa);
	
	@Query("Select l.idLop From Lop l WHERE l.tenLop = :tenLop")
	public String findIdByTenLop(@Param("tenLop") String tenLop);
}
