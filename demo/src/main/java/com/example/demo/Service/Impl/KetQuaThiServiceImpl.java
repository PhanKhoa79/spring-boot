package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.DeThi;
import com.example.demo.Model.KetQuaThi;
import com.example.demo.Model.Lop;
import com.example.demo.Model.MonThi;
import com.example.demo.Model.SinhVien;
import com.example.demo.Repository.DeThiRepository;
import com.example.demo.Repository.KetQuaThiRepository;
import com.example.demo.Repository.LopRepository;
import com.example.demo.Repository.MonThiRepository;
import com.example.demo.Repository.SinhVienRepository;
import com.example.demo.Service.KetQuaThiService;

@Service
public class KetQuaThiServiceImpl implements KetQuaThiService{
	@Autowired
	private KetQuaThiRepository ketQuaThiRepository;
	
	@Autowired
	private LopRepository lopRepository;
	
	@Autowired
	private SinhVienRepository sinhVienRepository;
	
	@Autowired
	private DeThiRepository deThiRepository;
	
	@Autowired
	private MonThiRepository monThiRepository;

	@Override
	public List<KetQuaThi> getAllByIdMonThi(String idMonThi) {
		List<KetQuaThi> listKQThi = ketQuaThiRepository.findByIdMonThi(idMonThi);
		for(KetQuaThi ketQuaThi : listKQThi) {
			String idLop = ketQuaThi.getIdLop();
			String idSinhVien = ketQuaThi.getIdSinhVien();
			String idDeThi = ketQuaThi.getIdDeThi();
			if(idDeThi != null) {
				DeThi dethi = deThiRepository.getReferenceById(idDeThi);
				ketQuaThi.setTenDeThi(dethi.getTenDeThi());
			}
			
			Lop lop = lopRepository.getReferenceById(idLop);
			MonThi monthi = monThiRepository.getReferenceById(idMonThi);
			SinhVien sinhvien = sinhVienRepository.getReferenceById(idSinhVien);
			
			ketQuaThi.setTenLop(lop.getTenLop());
			ketQuaThi.setTenMonThi(monthi.getTenMonThi());
			ketQuaThi.setTenSinhVien(sinhvien.getTenSinhVien());
		}
		return listKQThi;
	}

	@Override
	public List<KetQuaThi> getAllByIdMonThiAndIdLop(String idMonThi, String idLop) {
		List<KetQuaThi> listKQThi = ketQuaThiRepository.findByIdMonThiAndIdLop(idMonThi, idLop);
		for(KetQuaThi ketQuaThi : listKQThi) {
			String idSinhVien = ketQuaThi.getIdSinhVien();
			String idDeThi = ketQuaThi.getIdDeThi();
			
			if(idDeThi != null) {
				DeThi dethi = deThiRepository.getReferenceById(idDeThi);
				ketQuaThi.setTenDeThi(dethi.getTenDeThi());
			}
			
			Lop lop = lopRepository.getReferenceById(idLop);
			MonThi monthi = monThiRepository.getReferenceById(idMonThi);
			SinhVien sinhvien = sinhVienRepository.getReferenceById(idSinhVien);
			
			ketQuaThi.setTenLop(lop.getTenLop());
			ketQuaThi.setTenMonThi(monthi.getTenMonThi());
			ketQuaThi.setTenSinhVien(sinhvien.getTenSinhVien());
		}
		return listKQThi;
	}

	@Override
	public List<KetQuaThi> getKetQuaThiByConditions(String idMonThi, String idLop, double diemThi1, double diemThi2) {
		List<KetQuaThi> listKQThi = ketQuaThiRepository.findByConditions(idMonThi, idLop, diemThi1, diemThi2);
		for(KetQuaThi ketQuaThi : listKQThi) {
			String idSinhVien = ketQuaThi.getIdSinhVien();
			String idDeThi = ketQuaThi.getIdDeThi();
			
			if(idDeThi != null) {
				DeThi dethi = deThiRepository.getReferenceById(idDeThi);
				ketQuaThi.setTenDeThi(dethi.getTenDeThi());
			}
			
			Lop lop = lopRepository.getReferenceById(idLop);
			MonThi monthi = monThiRepository.getReferenceById(idMonThi);
			SinhVien sinhvien = sinhVienRepository.getReferenceById(idSinhVien);
			
			ketQuaThi.setTenLop(lop.getTenLop());
			ketQuaThi.setTenMonThi(monthi.getTenMonThi());
			ketQuaThi.setTenSinhVien(sinhvien.getTenSinhVien());
		}
		return listKQThi;
	}

	@Override
	public KetQuaThi createKetQuaThi(KetQuaThi kqThi) {
		return ketQuaThiRepository.save(kqThi);
	}

	@Override
	public List<KetQuaThi> getAllByIdSinhVien(String idSinhVien) {
		List<KetQuaThi> listKQThi = ketQuaThiRepository.findByIdSinhVien(idSinhVien);
		for(KetQuaThi ketQuaThi : listKQThi) {
			String idMonThi = ketQuaThi.getIdMonThi();
			String idDeThi = ketQuaThi.getIdDeThi();
			if(idDeThi != null) {
				DeThi dethi = deThiRepository.getReferenceById(idDeThi);
				ketQuaThi.setTenDeThi(dethi.getTenDeThi());
			}
			
			MonThi monthi = monThiRepository.getReferenceById(idMonThi);	

			ketQuaThi.setTenMonThi(monthi.getTenMonThi());

		}
		return listKQThi;
	}
}
