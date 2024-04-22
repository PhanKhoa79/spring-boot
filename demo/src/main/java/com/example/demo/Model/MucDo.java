package com.example.demo.Model;

import org.hibernate.internal.build.AllowNonPortable;

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
@Table(name = "mucdo")
public class MucDo {

    @Id
    @Column(name = "IdMucDo")
    private String idMucDo;

    @Column(name = "TenMucDo")
    private String tenMucDo;

}
