package com.example.demo.Controller;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.SinhVien;
import com.example.demo.Model.DTO.SinhVienDTO;
import com.example.demo.Repository.SinhVienRepository;
import com.example.demo.Service.SinhVienService;
import com.mysql.cj.jdbc.Blob;

@RestController
@RequestMapping("/api/sinhvien")
public class SinhVienController {
	@Autowired
	private SinhVienService sinhVienService;
	
	@PostMapping("/add/student")
	public ResponseEntity<?> createSinhVien(@RequestBody SinhVienDTO sinhVienDTO) {
		SinhVien sinhvien = new SinhVien();
		sinhvien.setIdSinhVien(sinhVienDTO.getIdSinhVien());
		sinhvien.setTenSinhVien(sinhVienDTO.getTenSinhVien());
		sinhvien.setIdLop(sinhVienDTO.getIdLop());
		sinhvien.setIdKhoa(sinhVienDTO.getIdKhoa());
		sinhvien.setNgaySinh(sinhVienDTO.getNgaySinh());
		sinhvien.setGioiTinh(sinhVienDTO.getGioiTinh());
		sinhvien.setDiaChi(sinhVienDTO.getDiaChi());
		sinhvien.setSdt(sinhVienDTO.getSdt());
		if(!sinhVienService.getSinhVienById(sinhvien.getIdSinhVien())) {
			sinhVienService.createSinhVien(sinhvien);
			return new ResponseEntity<SinhVien>(sinhvien, HttpStatus.CREATED);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Lỗi không thể tạo sinh viên!");
		}
	}
	
	@PutMapping("/update/student")
	public ResponseEntity<?> updateSinhVien(@RequestParam("id") String idSinhVien, @RequestBody SinhVienDTO sinhVienDTO) {
		SinhVien sinhvien = sinhVienService.updateSinhVien(idSinhVien, sinhVienDTO);
		if(sinhvien != null) {
			return ResponseEntity.ok(sinhvien);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Lỗi không thể cập nhật sinh viên!"); 
		}
	}
	
	@DeleteMapping("/delete/student")
	public ResponseEntity<?> deleteSinhVien(@RequestParam("id") String idSinhVien) {
		if(sinhVienService.deleteSinhVien(idSinhVien)) {
			return ResponseEntity.status(HttpStatus.OK).body("Xóa thành công!");
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Không thể xóa sinh viên này!"); 
		}
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<SinhVien>> getAllSinhVien() {
		return ResponseEntity.ok(sinhVienService.getAllSinhVien());
	}
	
	@GetMapping("/students/s1/{idKhoa}")
	public ResponseEntity<List<SinhVien>> getAllSinhVienByIdKhoa(@PathVariable String idKhoa) {
		return ResponseEntity.ok(sinhVienService.getAllSinhVienByIdKhoa(idKhoa));
	}
	
	@GetMapping("/students/s2/{idLop}")
	public ResponseEntity<List<SinhVien>> getAllSinhVienByIdLop(@PathVariable String idLop) {
		return ResponseEntity.ok(sinhVienService.getAllSinhVienByIdLop(idLop));
	}
	
	@GetMapping("/students/search")
	public ResponseEntity<List<SinhVien>> getAllSinhVienByIdAndTen(@RequestParam("keyword") String keyword) {
		return ResponseEntity.ok(sinhVienService.getAllSinhVienByIdAndTen(keyword));
	}
	
	@PutMapping("student/{idSinhVien}/image")
	public ResponseEntity<?> updateAnhSinhVien(@PathVariable String idSinhVien, @RequestBody byte[] anhSinhVien) {
	        sinhVienService.updateAnhSinhVien(idSinhVien, anhSinhVien);
	        return ResponseEntity.ok("Cập nhật ảnh thành công!");
	}
}
