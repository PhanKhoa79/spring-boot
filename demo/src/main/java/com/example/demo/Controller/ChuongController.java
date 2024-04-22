package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Chuong;
import com.example.demo.Service.ChuongService;

@RestController
@RequestMapping("/api/chuong")
public class ChuongController {
	@Autowired
	private ChuongService chuongService;
	
	@GetMapping("/chapters")
	public ResponseEntity<List<Chuong>> getAllChuong() {
		List<Chuong> listChuong = chuongService.getAllChuong();
		return ResponseEntity.ok(listChuong);
	}
	
	@GetMapping("/chapters/{idMonThi}")
	public ResponseEntity<List<Chuong>> getAllChuongByIdMonThi(@PathVariable String idMonThi) {
		List<Chuong> listChuong = chuongService.getAllChuongByIdMonThi(idMonThi);
		return ResponseEntity.ok(listChuong);
	}
	
	@GetMapping("/chapter")
	public ResponseEntity<String> getIdByName(@RequestParam("name") String name, @RequestParam("id") String idMonThi) {
		return ResponseEntity.ok(chuongService.getIdByName(name, idMonThi));
	} 
}
