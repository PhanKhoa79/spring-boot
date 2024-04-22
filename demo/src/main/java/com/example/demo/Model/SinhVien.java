package com.example.demo.Model;

import java.sql.Date;
import java.sql.Types;

import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.annotations.JdbcTypeCode;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.mysql.cj.jdbc.Blob;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "sinhvien")
public class SinhVien {

    @Id
    @Column(name = "IdSinhVien")
    private String idSinhVien;

    @Column(name = "TenSinhVien")
    private String tenSinhVien;

    @Column(name = "IdLop")
    private String idLop;

    @Column(name = "IdKhoa")
    private String idKhoa;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SDT")
    private String sdt;

    @Column(name = "TaiKhoan")
    private String taiKhoan;

    @Lob
    @Column(name = "AnhSinhVien", columnDefinition = "LONGBLOB")
    private byte[] anhSinhVien;
    
    @Transient
    private String tenLop;
    
    @Transient 
    private String tenKhoa;

}
