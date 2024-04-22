package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.SinhVien;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, String>{
	
	public List<SinhVien> findByIdLop(String idLop);
	
	public List<SinhVien> findByIdKhoa(String idKhoa);
	
	@Query("SELECT sv FROM SinhVien sv WHERE sv.idSinhVien LIKE %:keyword% OR sv.tenSinhVien LIKE %:keyword%")
    List<SinhVien> findByKeyword(String keyword);
}
