package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Khoa;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, String>{
	
	@Query("Select k.idKhoa From Khoa k WHERE k.tenKhoa = :tenKhoa")
	public String findIdByTenKhoa(@Param("tenKhoa") String tenKhoa);

}
