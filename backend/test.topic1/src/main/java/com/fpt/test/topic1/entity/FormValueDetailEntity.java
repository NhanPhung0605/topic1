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
@Table(name = "form_value_detail_tbl")
public class FormValueDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_value_detail_id")
    private Long formValueDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_value_id")
    private FormValueEntity formValueEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_detail_id")
    private FormDetailEntity formDetailEntity;

    @Column(name = "value_num")
    private Long valueNum;

    @Column(name = "value_bool")
    private Boolean valueBool;
}
