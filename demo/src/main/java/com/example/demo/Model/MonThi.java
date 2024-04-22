package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "monthi")
public class MonThi {

    @Id
    @Column(name = "IdMonThi")
    private String idMonThi;

    @Column(name = "TenMonThi")
    private String tenMonThi;


}