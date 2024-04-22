package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "phanquyen")
public class PhanQuyen {
	@Id
    @Column(name = "ID_PhanQuyen")
    private Integer idPhanQuyen;

    @Column(name = "Ten_PhanQuyen")
    private String tenPhanQuyen;
}
