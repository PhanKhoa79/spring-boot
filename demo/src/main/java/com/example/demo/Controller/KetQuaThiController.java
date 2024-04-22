package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.KetQuaThi;
import com.example.demo.Service.KetQuaThiService;

@RestController
@RequestMapping("/api/ketquathi")
public class KetQuaThiController {
	@Autowired
	private KetQuaThiService ketQuaThiService;
	
	@PostMapping("/add/result")
	public ResponseEntity<KetQuaThi> createKetQuaThi(@RequestBody KetQuaThi kqThi) {
		return ResponseEntity.ok(ketQuaThiService.createKetQuaThi(kqThi));
	}
	
	@GetMapping("/results/r1")
	public ResponseEntity<List<KetQuaThi>> getAllByIdMonThi(@RequestParam("id") String idMonThi) {
		return ResponseEntity.ok(ketQuaThiService.getAllByIdMonThi(idMonThi));
	}
	
	@GetMapping("/results/r2")
	public ResponseEntity<List<KetQuaThi>> getAllByIdMonThiAndIdLop(@RequestParam("id1") String idMonThi, @RequestParam("id2") String idLop) {
		return ResponseEntity.ok(ketQuaThiService.getAllByIdMonThiAndIdLop(idMonThi, idLop));
	}
	
	@GetMapping("/results/r3/{id1}/{id2}/{diem1}/{diem2}")
	public ResponseEntity<List<KetQuaThi>> getAllByConditions(@PathVariable String id1, @PathVariable String id2, @PathVariable double diem1, @PathVariable double diem2) {
		return ResponseEntity.ok(ketQuaThiService.getKetQuaThiByConditions(id1, id2, diem1, diem2)); 
	}
	
	@GetMapping("/results/r4")
	public ResponseEntity<List<KetQuaThi>> getAllByIdSinhVien(@RequestParam("id") String idSinhVien) {
		return ResponseEntity.ok(ketQuaThiService.getAllByIdSinhVien(idSinhVien));
	}
}
