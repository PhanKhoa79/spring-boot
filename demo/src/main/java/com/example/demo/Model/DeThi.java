package com.example.demo.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "dethi")
public class DeThi {
    @Id
    @Column(name = "IdDeThi")
    private String idDeThi;

    @Column(name = "TenDeThi")
    private String tenDeThi;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "DiemToiDa")
    private Integer diemToiDa;

    @Column(name = "IdMonThi")
    private String idMonThi;

    @Column(name = "SoLuongCauHoi")
    private Integer soLuongCauHoi;

    @Column(name = "ThoiGianThi")
    private Integer thoiGianThi;

    @Transient
    private String tenMonThi;
  
}
