package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ChiTietDeThi;
import com.example.demo.Repository.ChiTietDeThiRepository;
import com.example.demo.Service.ChiTietDeThiService;

@Service
public class ChiTietDeThiServiceImpl implements ChiTietDeThiService{
	@Autowired
	private ChiTietDeThiRepository ctdtRepository;

	@Override
	public ChiTietDeThi createChiTietDeThi(ChiTietDeThi ctdt) {
		return ctdtRepository.save(ctdt);
	}

	@Override
	public void deleteChiTietDeThi(String idDeThi) {
		 ctdtRepository.deleteByIdDeThi(idDeThi);
	}

	@Override
	public List<ChiTietDeThi> getAllByIdDeThi(String idDeThi) {
		return ctdtRepository.findByIdDeThi(idDeThi);
	}
	
	
}
