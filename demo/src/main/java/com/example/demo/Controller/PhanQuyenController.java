package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.Model.PhanQuyen;
import com.example.demo.Service.PhanQuyenService;

@RestController
@RequestMapping("/api/phanquyen")
public class PhanQuyenController {
	@Autowired
	private PhanQuyenService phanQuyenService;
	
	@GetMapping("/roles")
	public ResponseEntity<List<PhanQuyen>> getAllRoles() {
		List<PhanQuyen> roles = phanQuyenService.getAllRoles();
		return ResponseEntity.ok(roles);
	}
	
	@GetMapping("/role/{id}")
	public ResponseEntity<?> getRoleById(@PathVariable int id) {
		PhanQuyen role = phanQuyenService.getRoleById(id);
		if(role == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy quyền!");
		} else {
			return ResponseEntity.ok(role);
		}
	}
}
