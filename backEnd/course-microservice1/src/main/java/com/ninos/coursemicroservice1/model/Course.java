package com.ninos.coursemicroservice1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "subtitle", length = 100, nullable = false)
    private String subtitle;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;




}