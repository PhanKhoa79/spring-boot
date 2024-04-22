package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Khoa;

public interface KhoaService {
	public List<Khoa> getAllKhoa(); 
	
	public String findIdByTenKhoa(String tenKhoa);
}
