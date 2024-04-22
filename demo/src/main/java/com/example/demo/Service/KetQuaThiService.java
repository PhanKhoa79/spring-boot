package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.KetQuaThi;

public interface KetQuaThiService {
	
	public List<KetQuaThi> getAllByIdSinhVien(String idSinhVien);
	
	public List<KetQuaThi> getAllByIdMonThi(String idMonThi);
	
	public List<KetQuaThi> getAllByIdMonThiAndIdLop(String idMonThi, String idLop);
	
	public List<KetQuaThi> getKetQuaThiByConditions(String idMonThi, String idLop, double diemThi1, double diemThi2);
	
	public KetQuaThi createKetQuaThi(KetQuaThi kqThi);
}
