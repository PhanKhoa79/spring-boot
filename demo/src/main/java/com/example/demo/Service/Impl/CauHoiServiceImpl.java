package com.example.demo.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.CauHoi;
import com.example.demo.Model.ChiTietDeThi;
import com.example.demo.Model.Chuong;
import com.example.demo.Model.MonThi;
import com.example.demo.Model.MucDo;
import com.example.demo.Repository.CauHoiRepository;
import com.example.demo.Repository.ChiTietDeThiRepository;
import com.example.demo.Repository.ChuongRepository;
import com.example.demo.Repository.MonThiRepository;
import com.example.demo.Repository.MucDoRepository;
import com.example.demo.Service.CauHoiService;

@Service
public class CauHoiServiceImpl implements CauHoiService{
	
	@Autowired
	private CauHoiRepository cauHoiRepository;
	
	@Autowired
	private MonThiRepository monThiRepository;
	
	@Autowired
	private MucDoRepository mucDoRepository;
	
	@Autowired
	private ChuongRepository chuongRepository;
	
	@Autowired
	private ChiTietDeThiRepository ctdtRepository;

	@Override
	public List<CauHoi> getAllCauHoi() {
		List<CauHoi> listCauHoi = cauHoiRepository.findAll();
		for(CauHoi cauHoi : listCauHoi) {
			String idMonThi = cauHoi.getIdMonThi();
			String idMucDo = cauHoi.getIdMucDo();
			String idChuong = cauHoi.getIdChuong();
			
			MonThi monThi = monThiRepository.getReferenceById(idMonThi);
			MucDo mucDo = mucDoRepository.getReferenceById(idMucDo);
			Chuong chuong = chuongRepository.getReferenceById(idChuong);
			
			cauHoi.setTenMonThi(monThi.getTenMonThi());
			cauHoi.setTenMucDo(mucDo.getTenMucDo());
			cauHoi.setTenChuong(chuong.getTenChuong());
			
		}
		return listCauHoi;
	}

	@Override
	public CauHoi getCauHoiById(int id) {
		Optional<CauHoi> optionalCauHoi = cauHoiRepository.findById(id);
		if(optionalCauHoi.isPresent()) {
			return optionalCauHoi.get();
		}
		return null;
	}

	@Override
	public List<CauHoi> getAllCauHoiByIdMonThi(String idMonThi) {
		List<CauHoi> listCauHoi = cauHoiRepository.findByIdMonThi(idMonThi);
		for(CauHoi cauHoi : listCauHoi) {
			String idMucDo = cauHoi.getIdMucDo();
			String idChuong = cauHoi.getIdChuong();
			
			MonThi monThi = monThiRepository.getReferenceById(idMonThi);
			MucDo mucDo = mucDoRepository.getReferenceById(idMucDo);
			Chuong chuong = chuongRepository.getReferenceById(idChuong);
			
			cauHoi.setTenMonThi(monThi.getTenMonThi());
			cauHoi.setTenMucDo(mucDo.getTenMucDo());
			cauHoi.setTenChuong(chuong.getTenChuong());
			
		}
		return listCauHoi;
	}

	@Override
	public List<CauHoi> getAllCauHoiByIdMonThiAndIdChuong(String idMonThi, String idChuong) {
		List<CauHoi> listCauHoi = cauHoiRepository.findByIdMonThiAndIdChuong(idMonThi, idChuong);
		for(CauHoi cauHoi : listCauHoi) {

			String idMucDo = cauHoi.getIdMucDo();
			
			MonThi monThi = monThiRepository.getReferenceById(idMonThi);
			MucDo mucDo = mucDoRepository.getReferenceById(idMucDo);
			Chuong chuong = chuongRepository.getReferenceById(idChuong);
			
			cauHoi.setTenMonThi(monThi.getTenMonThi());
			cauHoi.setTenMucDo(mucDo.getTenMucDo());
			cauHoi.setTenChuong(chuong.getTenChuong());
			
		}
		return listCauHoi;
	}

	@Override
	public List<CauHoi> getAllCauHoiByIdMonThiAndIdMucDo(String idMonThi, String idMucDo) {
		List<CauHoi> listCauHoi = cauHoiRepository.findByIdMonThiAndIdMucDo(idMonThi, idMucDo);
		for(CauHoi cauHoi : listCauHoi) {
			
			String idChuong = cauHoi.getIdChuong();
			
			MonThi monThi = monThiRepository.getReferenceById(idMonThi);
			MucDo mucDo = mucDoRepository.getReferenceById(idMucDo);
			Chuong chuong = chuongRepository.getReferenceById(idChuong);
			
			cauHoi.setTenMonThi(monThi.getTenMonThi());
			cauHoi.setTenMucDo(mucDo.getTenMucDo());
			cauHoi.setTenChuong(chuong.getTenChuong());
			
		}
		return listCauHoi;
	}

	@Override
	public List<CauHoi> getAllCauHoiByKeyWord(String cauHoi) {
		List<CauHoi> listCauHoi = cauHoiRepository.findByCauHoiContaining(cauHoi);
		for(CauHoi cauhoi : listCauHoi) {
			String idMonThi = cauhoi.getIdMonThi();
			String idMucDo = cauhoi.getIdMucDo();
			String idChuong = cauhoi.getIdChuong();
			
			MonThi monThi = monThiRepository.getReferenceById(idMonThi);
			MucDo mucDo = mucDoRepository.getReferenceById(idMucDo);
			Chuong chuong = chuongRepository.getReferenceById(idChuong);
			
			cauhoi.setTenMonThi(monThi.getTenMonThi());
			cauhoi.setTenMucDo(mucDo.getTenMucDo());
			cauhoi.setTenChuong(chuong.getTenChuong());
			
		}
		return listCauHoi;
	}

	@Override
	public CauHoi createCauHoi(CauHoi cauHoi) {
		return cauHoiRepository.save(cauHoi);
	}

	@Override
	public CauHoi updateCauHoi(int idCauHoi, CauHoi cauHoi) {
		CauHoi cauhoi = cauHoiRepository.getReferenceById(idCauHoi);
		if(cauhoi != null) {
			cauhoi.setCauHoi(cauHoi.getCauHoi());
			cauhoi.setDapAnA(cauHoi.getDapAnA());
			cauhoi.setDapAnB(cauHoi.getDapAnB());
			cauhoi.setDapAnC(cauHoi.getDapAnC());
			cauhoi.setDapAnD(cauHoi.getDapAnD());
			cauhoi.setDapAnDung(cauHoi.getDapAnDung());
			cauhoi.setIdMonThi(cauHoi.getIdMonThi());
			cauhoi.setIdMucDo(cauHoi.getIdMucDo());
			cauhoi.setIdChuong(cauHoi.getIdChuong());
			
			return cauHoiRepository.save(cauhoi);
		}
		return null;
	}

	@Override
	public boolean deleteCauHoi(int idCauHoi) {
		Optional<CauHoi> optionalCauHoi = cauHoiRepository.findById(idCauHoi);
		if(optionalCauHoi.isPresent()) {
			try {
				cauHoiRepository.delete(optionalCauHoi.get());
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public List<CauHoi> getAllCauHoiByIdDeThi(String idDeThi) {
		List<ChiTietDeThi> chiTietDeThiList = ctdtRepository.findByIdDeThi(idDeThi);
        List<CauHoi> danhSachCauHoi = new ArrayList<>();
        for (ChiTietDeThi chiTietDeThi : chiTietDeThiList) {
            int idCauHoi = chiTietDeThi.getIdCauHoi();
            
            Optional<CauHoi> cauHoi = cauHoiRepository.findById(idCauHoi);
            if (cauHoi != null) {
                danhSachCauHoi.add(cauHoi.get());
            }
        }
        
        for(CauHoi cauhoi : danhSachCauHoi) {
        	String idMonThi = cauhoi.getIdMonThi();
			String idMucDo = cauhoi.getIdMucDo();
			String idChuong = cauhoi.getIdChuong();
			
			MonThi monThi = monThiRepository.getReferenceById(idMonThi);
			MucDo mucDo = mucDoRepository.getReferenceById(idMucDo);
			Chuong chuong = chuongRepository.getReferenceById(idChuong);
			
			cauhoi.setTenMonThi(monThi.getTenMonThi());
			cauhoi.setTenMucDo(mucDo.getTenMucDo());
			cauhoi.setTenChuong(chuong.getTenChuong());
        }
        return danhSachCauHoi;
	}

	@Override
	public List<Object[]> getAllCauHoiByDeThiId(String idDeThi) {
	    List<Object[]> allCauHoi = cauHoiRepository.getAllCauHoiByDeThiId(idDeThi);
	    int questionIndex = 1;
	    List<Object[]> numberedCauHoi = new ArrayList<>();

	    for (Object[] cauHoi : allCauHoi) {
	        Object[] numberedCauHoiItem = new Object[cauHoi.length + 1];
	        numberedCauHoiItem[0] = "Câu " + questionIndex;
	        System.arraycopy(cauHoi, 0, numberedCauHoiItem, 1, cauHoi.length);
	        numberedCauHoi.add(numberedCauHoiItem);
	        questionIndex++;
	    }

	    return numberedCauHoi;
	}

}
