package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Khoa;
import com.example.demo.Model.Lop;
import com.example.demo.Model.SinhVien;
import com.example.demo.Model.DTO.SinhVienDTO;
import com.example.demo.Repository.KhoaRepository;
import com.example.demo.Repository.LopRepository;
import com.example.demo.Repository.SinhVienRepository;
import com.example.demo.Service.SinhVienService;
import com.mysql.cj.jdbc.Blob;

@Service
public class SinhVienServiceImpl implements SinhVienService{
	@Autowired
	private SinhVienRepository sinhVienRepository;
	
	@Autowired 
	private LopRepository lopRepository;
	
	@Autowired
	private KhoaRepository khoaRepository;

	@Override
	public List<SinhVien> getAllSinhVien() {
		List<SinhVien> listSinhVien = sinhVienRepository.findAll();
		for(SinhVien sinhvien : listSinhVien) {
			String idLop = sinhvien.getIdLop();
			String idKhoa = sinhvien.getIdKhoa();
			
			Lop lop = lopRepository.getReferenceById(idLop);
			Khoa khoa = khoaRepository.getReferenceById(idKhoa);
			
			sinhvien.setTenLop(lop.getTenLop());
			sinhvien.setTenKhoa(khoa.getTenKhoa());
		}
		return listSinhVien;
	}

	@Override
	public List<SinhVien> getAllSinhVienByIdKhoa(String idKhoa) {
		List<SinhVien> listSinhVien = sinhVienRepository.findByIdKhoa(idKhoa);
		for(SinhVien sinhvien : listSinhVien) {
			String idLop = sinhvien.getIdLop();
			
			Lop lop = lopRepository.getReferenceById(idLop);
			Khoa khoa = khoaRepository.getReferenceById(idKhoa);
			
			sinhvien.setTenLop(lop.getTenLop());
			sinhvien.setTenKhoa(khoa.getTenKhoa());
		}
		return listSinhVien;
	}

	@Override
	public List<SinhVien> getAllSinhVienByIdLop(String idLop) {
		List<SinhVien> listSinhVien = sinhVienRepository.findByIdLop(idLop);
		for(SinhVien sinhvien : listSinhVien) {
			String idKhoa = sinhvien.getIdKhoa();
			
			Lop lop = lopRepository.getReferenceById(idLop);
			Khoa khoa = khoaRepository.getReferenceById(idKhoa);
			
			sinhvien.setTenLop(lop.getTenLop());
			sinhvien.setTenKhoa(khoa.getTenKhoa());
		}
		return listSinhVien;
	}

	@Override
	public List<SinhVien> getAllSinhVienByIdAndTen(String keyword) {
		List<SinhVien> listSinhVien = sinhVienRepository.findByKeyword(keyword);
		for(SinhVien sinhvien : listSinhVien) {
			String idLop = sinhvien.getIdLop();
			String idKhoa = sinhvien.getIdKhoa();
			
			Lop lop = lopRepository.getReferenceById(idLop);
			Khoa khoa = khoaRepository.getReferenceById(idKhoa);
			
			sinhvien.setTenLop(lop.getTenLop());
			sinhvien.setTenKhoa(khoa.getTenKhoa());
		}
		return listSinhVien;
	}

	@Override
	public SinhVien createSinhVien(SinhVien sinhVien) {
		String idSinhVien = sinhVien.getIdSinhVien();
		Optional<SinhVien> optionalSinhVien = sinhVienRepository.findById(idSinhVien);
		if(!optionalSinhVien.isPresent()) {
			return sinhVienRepository.save(sinhVien);
		}
		return null;
	}

	@Override
	public SinhVien updateSinhVien(String idSinhVien, SinhVienDTO sinhVienDTO) {
		SinhVien sinhvien = sinhVienRepository.getReferenceById(idSinhVien);
		if(sinhvien != null) {
			sinhvien.setTenSinhVien(sinhVienDTO.getTenSinhVien());
			sinhvien.setIdLop(sinhVienDTO.getIdLop());
			sinhvien.setIdKhoa(sinhVienDTO.getIdKhoa());
			sinhvien.setNgaySinh(sinhVienDTO.getNgaySinh());
			sinhvien.setGioiTinh(sinhVienDTO.getGioiTinh());
			sinhvien.setDiaChi(sinhVienDTO.getDiaChi());
			sinhvien.setSdt(sinhVienDTO.getSdt());
			
			return sinhVienRepository.save(sinhvien);
		}
		return null;
	}

	@Override
	public boolean deleteSinhVien(String idSinhVien) {
		Optional<SinhVien> optionalSinhVien = sinhVienRepository.findById(idSinhVien);
		if(optionalSinhVien.isPresent()) {
			try {
				sinhVienRepository.delete(optionalSinhVien.get());
				return true;
			} catch(Exception e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean getSinhVienById(String idSinhVien) {
		Optional<SinhVien> optionalSinhVien = sinhVienRepository.findById(idSinhVien);
		if(optionalSinhVien.isPresent()) {
			return true;
		} else {
			return false;
		}		
	}

	@Override
	public void updateAnhSinhVien(String idSinhVien, byte[] anhSinhVien) {
		Optional<SinhVien> sinhVienOptional = sinhVienRepository.findById(idSinhVien);
		if (sinhVienOptional.isPresent()) {
            SinhVien sinhVien = sinhVienOptional.get();
            sinhVien.setAnhSinhVien(anhSinhVien);
            sinhVienRepository.save(sinhVien);
		}	
		
	}
	
	
}
