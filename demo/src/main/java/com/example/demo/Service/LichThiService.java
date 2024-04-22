package com.example.demo.Service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.LichThi;

public interface LichThiService {
	public List<LichThi> getLichThiByIdMonThi(String idMonThi);
	
	public LichThi createLichThi(LichThi lichThi);
	
	public LichThi updateLichThi(int idLichThi, LichThi lichThi);
	
	public boolean deleteLichThi(int idLichThi);
}
