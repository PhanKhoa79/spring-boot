package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.PhanQuyen;

public interface PhanQuyenService {
	public List<PhanQuyen> getAllRoles();
	
	public PhanQuyen getRoleById(int id);
}
