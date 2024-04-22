package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Model.MonThi;
import com.example.demo.Service.MonThiService;

@RestController
@RequestMapping("/api/monthi")
public class MonThiController {
	@Autowired
	private MonThiService monThiSevice;
	
	@PostMapping("/add/subject")
	public ResponseEntity<?> createMonThi(@RequestBody MonThi monThi) {
		MonThi monthi = monThiSevice.createMonThi(monThi);
		if(monthi != null) {
			return new ResponseEntity<MonThi>(monthi, HttpStatus.CREATED);
		} 
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Lỗi không thể tạo môn thi!");
	}
	
	@PutMapping("/update/subject")
	public ResponseEntity<?> updateMonThi(@RequestParam("id") String idMonThi, @RequestBody MonThi monThi) {
		MonThi monthi = monThiSevice.updateMonThi(idMonThi, monThi);
		if(monthi != null) {
			return ResponseEntity.ok(monthi); 
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Lỗi không thể sửa môn thi!");
	}
	
	@DeleteMapping("/delete/subject")
	public ResponseEntity<?> deleteDeThi(@RequestParam("id") String idMonThi) {
		if(monThiSevice.deleteMonThi(idMonThi)) {
			return ResponseEntity.ok("Xóa thành công!");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Không thể xóa môn thi này!");
	}
	
	@GetMapping("/subjects")
	public ResponseEntity<List<MonThi>> getAllMonThi() {
		List<MonThi> listMonThi = monThiSevice.getAllMonThi();
		return ResponseEntity.ok(listMonThi);
	}
	
	@GetMapping("/subject")
	public ResponseEntity<String> getIdByName(@RequestParam("name") String name) {
		return ResponseEntity.ok(monThiSevice.getIdByName(name));
	}
}
