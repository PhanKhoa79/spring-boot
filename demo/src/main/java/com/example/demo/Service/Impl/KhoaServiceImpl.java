package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Khoa;
import com.example.demo.Repository.KhoaRepository;
import com.example.demo.Service.KhoaService;

@Service
public class KhoaServiceImpl implements KhoaService{
	@Autowired
	private KhoaRepository khoaRepository;

	@Override
	public List<Khoa> getAllKhoa() {
		return khoaRepository.findAll();
	}

	@Override
	public String findIdByTenKhoa(String tenKhoa) {
		return khoaRepository.findIdByTenKhoa(tenKhoa);
	}
	
}
