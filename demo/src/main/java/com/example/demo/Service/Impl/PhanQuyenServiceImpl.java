package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.PhanQuyen;
import com.example.demo.Repository.PhanQuyenRepository;
import com.example.demo.Service.PhanQuyenService;

@Service
public class PhanQuyenServiceImpl implements PhanQuyenService{
	@Autowired
	private PhanQuyenRepository phanQuyenRepository;

	@Override
	public List<PhanQuyen> getAllRoles() {
		return phanQuyenRepository.findAll();
	}

	@Override
	public PhanQuyen getRoleById(int id) {
		Optional<PhanQuyen> optionalRole = phanQuyenRepository.findById(id);
		if(optionalRole.isPresent()) {
			return optionalRole.get();
		}
		return null;
	}

}
