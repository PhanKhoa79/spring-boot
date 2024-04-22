package com.example.demo.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "ketquathi")
public class KetQuaThi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "IdSinhVien")
    private String idSinhVien;

    @Column(name = "IdMonThi")
    private String idMonThi;

    @Column(name = "NgayThi")
    private Date ngayThi;

    @Column(name = "DiemThi")
    private Double diemThi;

    @Column(name = "IdLop")
    private String idLop;

    @Column(name = "IdDeThi")
    private String idDeThi;
    
    @Transient
    private String tenSinhVien;
    
    @Transient
    private String tenMonThi;
    
    @Transient
    private String tenLop;
    
    @Transient
    private String tenDeThi;
    
}
