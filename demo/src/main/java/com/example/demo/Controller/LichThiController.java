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

import com.example.demo.Model.CauHoi;
import com.example.demo.Model.LichThi;
import com.example.demo.Service.LichThiService;

@RestController
@RequestMapping("/api/lichthi")
public class LichThiController {
	@Autowired
	private LichThiService lichThiService;
	
	@PostMapping("/add/schedule")
	public ResponseEntity<?> createLichThi(@RequestBody LichThi lichThi) {
		LichThi lichthi = lichThiService.createLichThi(lichThi);
		if(lichthi != null) {
			return new ResponseEntity<LichThi>(lichthi, HttpStatus.CREATED);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Lỗi không thể tạo lịch thi!");
		}
	}
	
	@PutMapping("/update/schedule")
	public ResponseEntity<?> updateCauHoi(@RequestParam("id") int idLichThi, @RequestBody LichThi lichThi) {
		LichThi lichthi = lichThiService.updateLichThi(idLichThi, lichThi);
		if(lichthi != null) {
			return ResponseEntity.ok(lichthi);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Không thể cập nhật lịch thi!");
		}
	}
	
	@DeleteMapping("/delete/schedule")
	public ResponseEntity<?> deleteCauHoi(@RequestParam("id") int idLichThi) {
		if(lichThiService.deleteLichThi(idLichThi)) {
			return ResponseEntity.status(HttpStatus.OK).body("Xóa thành công!");
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Không thể xóa lịch thi này!");
		}
	}
	
	
	@GetMapping("/schedules")
	public ResponseEntity<List<LichThi>> getLichThiByIdMonThi(@RequestParam("id") String idMonThi) {
		return ResponseEntity.ok(lichThiService.getLichThiByIdMonThi(idMonThi));
	}
}
