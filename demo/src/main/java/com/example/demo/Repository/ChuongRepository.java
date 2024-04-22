package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Chuong;

@Repository
public interface ChuongRepository extends JpaRepository<Chuong, String>{
	List<Chuong> findByMonThi_IdMonThi(String idMonThi);
	
	//tạo câu truy vấn tùy chỉnh
	@Query("SELECT c.idChuong FROM Chuong c WHERE c.tenChuong = :tenChuong AND c.monThi.idMonThi = :idMonThi")
	String findIdChuongByTenChuong(@Param("tenChuong") String tenChuong, @Param("idMonThi") String idMonThi);
}
