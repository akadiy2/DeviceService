package com.project.DeviceService.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Consoles")
@Data
public class ConsoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private BrandEntity brandEntity;
}
