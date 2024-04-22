package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Chuong;

public interface ChuongService {
	public List<Chuong> getAllChuong();
	
	public List<Chuong> getAllChuongByIdMonThi(String idMonThi);
	
	public String getIdByName(String tenChuong, String idMonThi);
}
