package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.KetQuaThi;

@Repository
public interface KetQuaThiRepository extends JpaRepository<KetQuaThi, Integer>{
	
	public List<KetQuaThi> findByIdSinhVien(String idSinhVien);
	
	public List<KetQuaThi> findByIdMonThi(String idMonThi);
	
	public List<KetQuaThi> findByIdMonThiAndIdLop(String idMonThi, String idLop);
	
	@Query("SELECT k FROM KetQuaThi k WHERE k.idMonThi = :idMonThi AND k.idLop = :idLop AND k.diemThi >= :diemThi1 AND k.diemThi <= :diemThi2")
    public List<KetQuaThi> findByConditions(@Param("idMonThi") String idMonThi, @Param("idLop") String idLop, @Param("diemThi1") double diemThi1, @Param("diemThi2") double diemThi2);
}
