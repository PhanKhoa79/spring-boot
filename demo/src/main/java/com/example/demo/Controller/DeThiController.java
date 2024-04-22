package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.Model.ChiTietDeThi;
import com.example.demo.Model.DeThi;
import com.example.demo.Service.ChiTietDeThiService;
import com.example.demo.Service.DeThiService;

@RestController
@RequestMapping("/api/dethi")
public class DeThiController {
	@Autowired
	private DeThiService deThiService;
	
	@Autowired
	private ChiTietDeThiService ctdtService;
	
	@PostMapping("/add/exam")
	public ResponseEntity<?> createDeThi(@RequestBody DeThi deThi) {
		DeThi dethi = deThiService.createDeThi(deThi);
		if(dethi != null) {
			return new ResponseEntity<DeThi>(dethi, HttpStatus.CREATED);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Lỗi không thể tạo đề thi!");
		}
	}
	
	@PutMapping("/update/exam")
	public ResponseEntity<?> updateDeThi(@RequestParam("id") String idDeThi, @RequestBody DeThi deThi) {
		DeThi dethi = deThiService.updateDeThi(idDeThi, deThi);
		if(dethi != null) {
			return ResponseEntity.ok(dethi);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Lỗi không thể sửa đề thi!");
		}
	}
	
	@DeleteMapping("/delete/exam")
	public ResponseEntity<?> deleteDeThi(@RequestParam("id") String idDeThi) {
		if(deThiService.deleteDeThi(idDeThi)) {
			return ResponseEntity.ok("Xóa thành công!");
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Không thể xóa đề thi này!");
		}
	}
	
	@GetMapping("/exams")
	public ResponseEntity<List<DeThi>> getAllDeThiByIdMonThi(@RequestParam("id") String idMonThi) {
		List<DeThi> listDeThi = deThiService.getAllDeThiByIdMonThi(idMonThi);
		return ResponseEntity.ok(listDeThi);
	}
	
	@GetMapping("/exam/{id}")
	public ResponseEntity<?> getDeThiById(@PathVariable String id) {
		DeThi dethi = deThiService.getDeThiById(id);
		if(dethi != null) {
			return ResponseEntity.ok(dethi);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Đề thi không tồn tại!");
		}
	}
	
	@PostMapping("/add/detailExam")
	public ChiTietDeThi createChiTietDeThi(@RequestBody ChiTietDeThi ctdt) {
		return ctdtService.createChiTietDeThi(ctdt);
	}
	
	@DeleteMapping("/delete/detailExam")
	public void deleteChiTietDeThi(@RequestParam("id") String idDeThi) {
		 ctdtService.deleteChiTietDeThi(idDeThi);
	}
	
	@GetMapping("/detailExams")
	public List<ChiTietDeThi> getAllByIdDeThi(@RequestParam("id") String idDeThi) {
		return ctdtService.getAllByIdDeThi(idDeThi);
	}
}
