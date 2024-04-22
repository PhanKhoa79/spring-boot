package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "lop")
public class Lop {

    @Id
    @Column(name = "IdLop")
    private String idLop;

    @Column(name = "TenLop")
    private String tenLop;

    @ManyToOne
    @JoinColumn(name = "IdKhoa")
    private Khoa khoa;


}