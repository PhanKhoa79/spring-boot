package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.MucDo;

@Repository
public interface MucDoRepository extends JpaRepository<MucDo, String>{

	@Query("SELECT md.idMucDo FROM MucDo md WHERE md.tenMucDo = :tenMucDo")
	String findIdMucDoByTenMucDo(@Param("tenMucDo") String tenMucDo);
}
