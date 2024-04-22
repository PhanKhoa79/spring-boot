package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.ChiTietDeThi;

public interface ChiTietDeThiService {
	public ChiTietDeThi createChiTietDeThi(ChiTietDeThi ctdt);
	
	public void deleteChiTietDeThi(String idDeThi);
	
	public List<ChiTietDeThi> getAllByIdDeThi(String idDeThi);
}
