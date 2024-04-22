package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	public User findByTaiKhoanAndMatKhau(String taiKhoan, String matKhau);
	
	@Query("SELECT u.idPhanQuyen FROM User u WHERE u.taiKhoan = :taiKhoan")
    public Integer findIdPhanQuyenByTaiKhoan(@Param("taiKhoan") String taiKhoan);
}
