package com.example.demo.Model;

import java.sql.Date;
import java.sql.Time;

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
@Table(name = "lichthi")
public class LichThi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLichThi")
    private Integer idLichThi;

    @Column(name = "IdMonThi")
    private String idMonThi;

    @Column(name = "GioBatDau")
    private Time gioBatDau;

    @Column(name = "GioKetThuc")
    private Time gioKetThuc;

    @Column(name = "NgayLamBai")
    private Date ngayLamBai;
    
    @Transient
    private String tenMonThi;

}
