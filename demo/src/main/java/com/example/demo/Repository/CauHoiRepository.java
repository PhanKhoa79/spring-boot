package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.CauHoi;

@Repository
@EnableJpaRepositories
public interface CauHoiRepository extends JpaRepository<CauHoi, Integer>{
	public List<CauHoi> findByIdMonThi(String idMonThi);
	
	public List<CauHoi> findByIdMonThiAndIdChuong(String idMonThi, String idChuong);
	
	public List<CauHoi> findByIdMonThiAndIdMucDo(String idMonThi, String idMucDo);
	
	@Query("SELECT c FROM CauHoi c WHERE c.cauHoi LIKE %:keyword%")
    public List<CauHoi> findByCauHoiContaining(@Param("keyword") String cauHoi);
	
	@Query("SELECT " +
		       "c.idCauHoi, c.cauHoi, c.dapAnA, c.dapAnB, c.dapAnC, c.dapAnD, c.dapAnDung " +
		       "FROM CauHoi c " +
		       "JOIN ChiTietDeThi ct ON c.idCauHoi = ct.idCauHoi " +
		       "WHERE ct.idDeThi = :idDeThi")
		List<Object[]> getAllCauHoiByDeThiId(@Param("idDeThi") String idDeThi);
}
