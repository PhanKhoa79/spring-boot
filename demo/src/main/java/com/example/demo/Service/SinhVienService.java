package com.example.demo.Service;

import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.example.demo.Model.SinhVien;
import com.example.demo.Model.DTO.SinhVienDTO;
import com.mysql.cj.jdbc.Blob;

public interface SinhVienService {
	
	public SinhVien createSinhVien(SinhVien sinhVien);
	
	public SinhVien updateSinhVien(String idSinhVien, SinhVienDTO sinhVienDTO);
	
	public boolean deleteSinhVien(String idSinhVien);
	
	public List<SinhVien> getAllSinhVien();
	
	public List<SinhVien> getAllSinhVienByIdKhoa(String idKhoa);
	
	public List<SinhVien> getAllSinhVienByIdLop(String idLop);
	
	public List<SinhVien> getAllSinhVienByIdAndTen(String keyword); 
	
	public boolean getSinhVienById(String idSinhVien);
	
	public void updateAnhSinhVien(String idSinhVien, byte[] anhSinhVien);
}
