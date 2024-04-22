package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Lop;
import com.example.demo.Repository.LopRepository;
import com.example.demo.Service.LopService;

@Service
public class LopServiceImpl implements LopService{
	@Autowired
	private LopRepository lopRepository;

	@Override
	public List<Lop> findByIdKhoa(String idKhoa) {
		return lopRepository.findByKhoa_IdKhoa(idKhoa);
	}

	@Override
	public String findIdByTenLop(String tenLop) {
		return lopRepository.findIdByTenLop(tenLop);
	}

	@Override
	public List<Lop> getAllLop() {
		return lopRepository.findAll();
	}

}
