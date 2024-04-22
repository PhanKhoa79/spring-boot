package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.LichThi;
import com.example.demo.Model.MonThi;
import com.example.demo.Repository.LichThiRepository;
import com.example.demo.Repository.MonThiRepository;
import com.example.demo.Service.LichThiService;

@Service
public class LichThiServiceImpl implements LichThiService{
	@Autowired
	private LichThiRepository lichThiRepository;
	
	@Autowired
	private MonThiRepository monThiRepository;

	@Override
	public List<LichThi> getLichThiByIdMonThi(String idMonThi) {
		List<LichThi> listLichThi =  lichThiRepository.findByIdMonThi(idMonThi);
		for(LichThi lichthi : listLichThi) {
			MonThi monthi = monThiRepository.getReferenceById(idMonThi);
			
			lichthi.setTenMonThi(monthi.getTenMonThi());
		}
		
		return listLichThi;
	}

	@Override
	public LichThi createLichThi(LichThi lichThi) {
		return lichThiRepository.save(lichThi);
	}

	@Override
	public LichThi updateLichThi(int idLichThi, LichThi lichThi) {
		LichThi lichthi = lichThiRepository.getReferenceById(idLichThi);
		if(lichthi != null) {
			lichthi.setGioBatDau(lichThi.getGioBatDau());
			lichthi.setGioKetThuc(lichThi.getGioKetThuc());
			lichthi.setNgayLamBai(lichThi.getNgayLamBai());
			
			return lichThiRepository.save(lichthi);
		}
		return null;
	}

	@Override
	public boolean deleteLichThi(int idLichThi) {
		Optional<LichThi> optionalLichThi = lichThiRepository.findById(idLichThi);
		if(optionalLichThi.isPresent()) {
			try {
				lichThiRepository.delete(optionalLichThi.get());
				return true;
			} catch(Exception e){
				return false;
			}
		}
		return false;
	}
	
}
