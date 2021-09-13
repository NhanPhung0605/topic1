package com.fpt.test.topic1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author : Admin
 * @created : 12-Aug-21
 **/
@Entity
@Getter
@Setter
@Table(name = "form_detail_tbl")
public class FormDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_detail_id")
    private Long formDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id", insertable = false, updatable = false)
    private FormEntity formEntity;

    @Column(name = "field_name")
    private String fieldName;

    @Column(name = "field_type")
    private Integer fieldType;
}
