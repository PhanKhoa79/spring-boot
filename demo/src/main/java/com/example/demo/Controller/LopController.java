package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Lop;
import com.example.demo.Service.LopService;

@RestController
@RequestMapping("/api/lop")
public class LopController {
	@Autowired
	private LopService lopService;
	
	@GetMapping("/classes1")
	public ResponseEntity<List<Lop>> GetAllLop() {
		return ResponseEntity.ok(lopService.getAllLop());
	}
	
	@GetMapping("/classes")
	public ResponseEntity<List<Lop>> findByIdKhoa(@RequestParam("id") String idKhoa) {
		return ResponseEntity.ok(lopService.findByIdKhoa(idKhoa));
	}
	
	@GetMapping("/class")
	public ResponseEntity<String> findIdByTenLop(@RequestParam("name") String tenLop) {
		return ResponseEntity.ok(lopService.findIdByTenLop(tenLop));
	}
}
