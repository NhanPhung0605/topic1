package com.fpt.test.topic1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author : Admin
 * @created : 12-Aug-21
 **/
@Entity
@Getter
@Setter
@Table(name = "form_value_tbl")
public class FormValueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_value_id")
    private Long formValueId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id")
    private FormEntity formEntity;

    @Column(name = "created_date")
    private Date createdDate;

    @OneToMany(mappedBy = "formValueEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<FormValueDetailEntity> formValueDetailEntities;

    @OneToMany(mappedBy = "formValueEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<FormValueImageEntity> formValueImageEntities;
}
