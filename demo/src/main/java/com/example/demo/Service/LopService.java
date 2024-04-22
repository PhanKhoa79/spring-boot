package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Lop;

public interface LopService {
	public List<Lop> findByIdKhoa(String idKhoa);
	
	public String findIdByTenLop(String tenLop);
	
	public List<Lop> getAllLop();
}
