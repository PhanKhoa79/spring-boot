package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.DeThi;

public interface DeThiService {
	public List<DeThi> getAllDeThiByIdMonThi(String idMonThi);
	
	public DeThi getDeThiById(String id);
	
	public DeThi createDeThi(DeThi deThi);
	
	public DeThi updateDeThi(String id, DeThi deThi);
	
	public boolean deleteDeThi(String id);
	
}
