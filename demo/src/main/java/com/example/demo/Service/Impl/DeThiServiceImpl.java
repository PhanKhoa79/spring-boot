package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.DeThi;
import com.example.demo.Model.MonThi;
import com.example.demo.Repository.DeThiRepository;
import com.example.demo.Repository.MonThiRepository;
import com.example.demo.Service.DeThiService;

@Service
public class DeThiServiceImpl implements DeThiService{
	@Autowired
	private DeThiRepository deThiRepository;
	
	@Autowired
	private MonThiRepository monThiRepository;

	@Override
	public List<DeThi> getAllDeThiByIdMonThi(String idMonThi) {
		List<DeThi> listDeThi = deThiRepository.findByIdMonThi(idMonThi);
		for(DeThi dethi : listDeThi) {
			MonThi monthi = monThiRepository.getReferenceById(idMonThi);
			
			dethi.setTenMonThi(monthi.getTenMonThi());
		}
		return listDeThi;
	}

	@Override
	public DeThi getDeThiById(String id) {
		Optional<DeThi> optionalDeThi = deThiRepository.findById(id);
		if(optionalDeThi.isPresent()) {
			String idMonThi = optionalDeThi.get().getIdMonThi();
			MonThi monthi = monThiRepository.getReferenceById(idMonThi);
			
			optionalDeThi.get().setTenMonThi(monthi.getTenMonThi());
			return optionalDeThi.get();
		}
		return null;
	}

	@Override
	public DeThi createDeThi(DeThi deThi) {
		String idDeThi = deThi.getIdDeThi();
		Optional<DeThi> optionalDeThi = deThiRepository.findById(idDeThi);
		if(!optionalDeThi.isPresent()) {
			return deThiRepository.save(deThi);
		}
		return null;
	}

	@Override
	public DeThi updateDeThi(String id, DeThi deThi) {
		DeThi dethi = deThiRepository.getReferenceById(id);
		if(dethi != null) {
			dethi.setTenDeThi(deThi.getTenDeThi());
			dethi.setNgayTao(deThi.getNgayTao());
			dethi.setDiemToiDa(deThi.getDiemToiDa());
			dethi.setIdMonThi(deThi.getIdMonThi());
			dethi.setSoLuongCauHoi(deThi.getSoLuongCauHoi());
			dethi.setThoiGianThi(deThi.getThoiGianThi());
			
			return deThiRepository.save(dethi);
		}
		return null;
	}

	@Override
	public boolean deleteDeThi(String id) {
		Optional<DeThi> optionalDeThi = deThiRepository.findById(id);
		if(optionalDeThi.isPresent()) {
			try {
				deThiRepository.delete(optionalDeThi.get());
				return true;
			} catch(Exception e) {
				return false;
			}
		}
		return false;
	}
}
