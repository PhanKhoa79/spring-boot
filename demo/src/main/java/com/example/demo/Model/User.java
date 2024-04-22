package com.example.demo.Model;

import com.mysql.cj.x.protobuf.MysqlxCursor.Fetch;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tai_khoan")
public class User {
		@Id
	    @Column(name = "TaiKhoan")
	    private String taiKhoan;

	    @Column(name = "MatKhau")
	    private String matKhau;

	    @Column(name = "Email")
	    private String email;
	    
	    @Column(name = "ID_PhanQuyen")	
	    private Integer idPhanQuyen;

}
