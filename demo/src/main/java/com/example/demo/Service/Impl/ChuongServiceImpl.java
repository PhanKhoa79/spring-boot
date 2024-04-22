package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Chuong;
import com.example.demo.Repository.ChuongRepository;
import com.example.demo.Service.ChuongService;

@Service
public class ChuongServiceImpl implements ChuongService{
	@Autowired
	private ChuongRepository chuongRepository;

	@Override
	public List<Chuong> getAllChuongByIdMonThi(String idMonThi) {
		return chuongRepository.findByMonThi_IdMonThi(idMonThi);
	}

	@Override
	public List<Chuong> getAllChuong() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdByName(String tenChuong, String idMonThi) {
		return chuongRepository.findIdChuongByTenChuong(tenChuong, idMonThi);
	}

}
