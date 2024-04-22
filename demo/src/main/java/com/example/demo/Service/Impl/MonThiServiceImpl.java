package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.MonThi;
import com.example.demo.Repository.MonThiRepository;
import com.example.demo.Service.MonThiService;

@Service
public class MonThiServiceImpl implements MonThiService{
	@Autowired
	private MonThiRepository monThiRepository;

	@Override
	public List<MonThi> getAllMonThi() {
		return monThiRepository.findAll();
	}

	@Override
	public String getIdByName(String tenMonThi) {
		return monThiRepository.findIdMonThiByTenMonThi(tenMonThi);
	}

	@Override
	public MonThi createMonThi(MonThi monThi) {
		Optional<MonThi> optionalMonThi = monThiRepository.findById(monThi.getIdMonThi());
		if(!optionalMonThi.isPresent()) {
			return monThiRepository.save(monThi);
		}
		return null;
	}

	@Override
	public MonThi updateMonThi(String idMonThi, MonThi monThi) {
		MonThi monthi = monThiRepository.getReferenceById(idMonThi);
		if(monthi != null) {
			monthi.setTenMonThi(monThi.getTenMonThi());
			
			return monThiRepository.save(monthi);
		}
		return null;
	}

	@Override
	public boolean deleteMonThi(String idMonThi) {
		Optional<MonThi> optionalMonThi = monThiRepository.findById(idMonThi);
		if(optionalMonThi.isPresent()) {
			try {
				monThiRepository.delete(optionalMonThi.get());
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

}
