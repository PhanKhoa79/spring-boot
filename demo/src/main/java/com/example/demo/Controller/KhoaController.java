package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Khoa;
import com.example.demo.Service.KhoaService;

@RestController
@RequestMapping("/api/khoa")
public class KhoaController {
	@Autowired
	private KhoaService khoaService;
	
	@GetMapping("/departments")
	public ResponseEntity<List<Khoa>> getAllKhoa() {
		return ResponseEntity.ok(khoaService.getAllKhoa());
	}
	
	@GetMapping("/department")
	public ResponseEntity<String> findIdByTenKhoa(@RequestParam("name") String tenKhoa) {
		return ResponseEntity.ok(khoaService.findIdByTenKhoa(tenKhoa));
	}
}
