package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.MonThi;

public interface MonThiService {
	public List<MonThi> getAllMonThi();
	
	public String getIdByName(String tenMonThi); 
	
	public MonThi createMonThi(MonThi monThi);
	
	public MonThi updateMonThi(String idMonThi, MonThi monThi);
	
	public boolean deleteMonThi(String idMonThi);
}
