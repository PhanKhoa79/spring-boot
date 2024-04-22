package com.example.demo.Model;

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
@Table(name = "cauhoi")
public class CauHoi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdCauHoi")
	private Integer idCauHoi;
	
	@Column(name = "CauHoi")
    private String cauHoi;

    @Column(name = "Dap_An_A")
    private String dapAnA;

    @Column(name = "Dap_An_B")
    private String dapAnB;

    @Column(name = "Dap_An_C")
    private String dapAnC;

    @Column(name = "Dap_An_D")
    private String dapAnD;

    @Column(name = "DapAnDung")
    private String dapAnDung;

    @Column(name = "IdMonThi")
    private String idMonThi;

    @Column(name = "IdMucDo")
    private String idMucDo;

    @Column(name = "IdChuong")
    private String idChuong;
	
    @Transient
    private String tenMonThi;
    
    @Transient 
    private String tenMucDo;
    
    @Transient 
    private String tenChuong;
}
