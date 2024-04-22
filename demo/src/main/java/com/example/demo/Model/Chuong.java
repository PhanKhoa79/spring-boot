package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "chuong")
public class Chuong {

    @Id
    @Column(name = "IdChuong")
    private String idChuong;

    @Column(name = "TenChuong")
    private String tenChuong;

    @ManyToOne
    @JoinColumn(name = "IdMonThi")
    private MonThi monThi;


}
