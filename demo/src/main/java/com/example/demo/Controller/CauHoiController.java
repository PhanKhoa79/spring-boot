package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.CauHoi;
import com.example.demo.Repository.CauHoiRepository;
import com.example.demo.Service.CauHoiService;

@RestController
@RequestMapping("/api/cauhoi")
public class CauHoiController {
	@Autowired
	private CauHoiService cauHoiService;
		
	@PostMapping("/add/question")
	public ResponseEntity<?> createCauHoi(@RequestBody CauHoi cauHoi) {
		CauHoi cauhoi = cauHoiService.createCauHoi(cauHoi);
		if(cauhoi != null) {
			return new ResponseEntity<CauHoi>(cauhoi, HttpStatus.CREATED);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Lỗi không thể tạo câu hỏi!");
		}
	}
	
	@PutMapping("/update/question")
	public ResponseEntity<?> updateCauHoi(@RequestParam("id") int idCauHoi, @RequestBody CauHoi cauHoi) {
		CauHoi cauhoi = cauHoiService.updateCauHoi(idCauHoi, cauHoi);
		if(cauhoi != null) {
			return ResponseEntity.ok(cauhoi);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Không thể cập nhật câu hỏi!");
		}
	}
	
	@DeleteMapping("/delete/question")
	public ResponseEntity<?> deleteCauHoi(@RequestParam("id") int idCauHoi) {
		if(cauHoiService.deleteCauHoi(idCauHoi)) {
			return ResponseEntity.status(HttpStatus.OK).body("Xóa thành công!");
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Không thể xóa câu hỏi này!");
		}
	}
	
	@GetMapping("/questions")
	public ResponseEntity<List<CauHoi>> getAllCauHoi() {
		List<CauHoi> listCauHoi = cauHoiService.getAllCauHoi();
		return ResponseEntity.ok(listCauHoi);
	}
	
	@GetMapping("/question/{id}")
	public ResponseEntity<?> getCauHoiById(@PathVariable int id) {
		CauHoi cauHoi = cauHoiService.getCauHoiById(id);
		if(cauHoi != null) {
			return ResponseEntity.ok(cauHoi);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Câu hỏi không tồn tại!");
		}
	}
	
	@GetMapping("/questions/q1")
	public ResponseEntity<List<CauHoi>> getAllCauHoiByIdMonThi(@RequestParam("id") String idMonThi) {
		List<CauHoi> listCauHoi = cauHoiService.getAllCauHoiByIdMonThi(idMonThi);
		return ResponseEntity.ok(listCauHoi);
	}
	
	@GetMapping("/questions/q2")
	public ResponseEntity<List<CauHoi>> getAllCauHoiByIdMonThiAndIdChuong(@RequestParam("id1") String idMonThi, @RequestParam("id2") String idChuong) {
		List<CauHoi> listCauHoi = cauHoiService.getAllCauHoiByIdMonThiAndIdChuong(idMonThi, idChuong);
		return ResponseEntity.ok(listCauHoi);
	} 
	
	@GetMapping("/questions/q3")
	public ResponseEntity<List<CauHoi>> getAllCauHoiByIdMonThiAndIdMucDo(@RequestParam("id1") String idMonThi, @RequestParam("id2") String idMucDo) {
		List<CauHoi> listCauHoi = cauHoiService.getAllCauHoiByIdMonThiAndIdMucDo(idMonThi, idMucDo);
		return ResponseEntity.ok(listCauHoi);
	}
	
	@GetMapping("/questions/searchBy")
	public ResponseEntity<List<CauHoi>> getAllCauHoiByKeyWord(@RequestParam("keyword") String cauHoi) {
		List<CauHoi> listCauHoi = cauHoiService.getAllCauHoiByKeyWord(cauHoi);
		return ResponseEntity.ok(listCauHoi);
	}
	
	@GetMapping("/questions/q4")
	public ResponseEntity<List<CauHoi>> getAllCauHoiByIdDeThi(@RequestParam("id") String idDeThi) {
		List<CauHoi> listCauHoi = cauHoiService.getAllCauHoiByIdDeThi(idDeThi);
		return ResponseEntity.ok(listCauHoi);
	}
	
	@GetMapping("/questions/q5")
	public ResponseEntity<List<Object[]>> getAllCauHoiByDeThiId(@RequestParam("id") String idDeThi) {
		List<Object[]> listCauHoi = cauHoiService.getAllCauHoiByDeThiId(idDeThi);
		return ResponseEntity.ok(listCauHoi);
	}
}
