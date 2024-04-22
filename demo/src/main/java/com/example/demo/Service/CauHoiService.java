package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.CauHoi;

public interface CauHoiService {
	public List<CauHoi> getAllCauHoi();
	
	public CauHoi getCauHoiById(int id);
	
	public CauHoi createCauHoi(CauHoi cauHoi);
	
	public CauHoi updateCauHoi(int idCauHoi, CauHoi cauHoi);
	
	public boolean deleteCauHoi(int idCauHoi);
	
	public List<CauHoi> getAllCauHoiByIdMonThi(String idMonThi);
	
	public List<CauHoi> getAllCauHoiByIdMonThiAndIdChuong(String idMonThi, String idChuong);
	
	public List<CauHoi> getAllCauHoiByIdMonThiAndIdMucDo(String idMonThi, String idMucDo);
	
	public List<CauHoi> getAllCauHoiByKeyWord(String cauHoi);
	
	public List<CauHoi> getAllCauHoiByIdDeThi(String idDeThi);
	
	public List<Object[]> getAllCauHoiByDeThiId(String idDeThi);
	
}
