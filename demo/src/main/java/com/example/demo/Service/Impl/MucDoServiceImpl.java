package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.MucDo;
import com.example.demo.Repository.MucDoRepository;
import com.example.demo.Service.MucDoService;

@Service
public class MucDoServiceImpl implements MucDoService{
	@Autowired
	private MucDoRepository mucDoRepository;

	@Override
	public List<MucDo> getlAllMucDo() {
		return mucDoRepository.findAll();
	}

	@Override
	public String getIdByName(String tenMucDo) {
		return mucDoRepository.findIdMucDoByTenMucDo(tenMucDo);
	}

	
}
