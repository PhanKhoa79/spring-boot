package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.MucDo;

public interface MucDoService {
	public List<MucDo> getlAllMucDo();
	
	public String getIdByName(String tenMucDo);
}
