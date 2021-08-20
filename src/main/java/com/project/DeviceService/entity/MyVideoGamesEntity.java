package com.project.DeviceService.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MyVideoGames")
public class MyVideoGamesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", updatable = false, insertable = false)
    private BrandEntity brandEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "console_id", referencedColumnName = "id", updatable = false, insertable = false)
    private ConsoleEntity consoleEntity;

    @Column(name = "progress")
    private int progress;


}
