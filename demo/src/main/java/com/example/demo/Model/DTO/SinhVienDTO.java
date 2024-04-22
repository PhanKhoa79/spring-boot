package com.example.demo.Model.DTO;

import java.sql.Date;

import com.example.demo.Model.Khoa;
import com.example.demo.Model.Lop;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SinhVienDTO {

	    private String idSinhVien;

	    private String tenSinhVien;

	    private String idLop;

	    private String idKhoa;

	    private Date ngaySinh;

	    private Boolean gioiTinh;

	    private String diaChi;

	    private String sdt;
}
