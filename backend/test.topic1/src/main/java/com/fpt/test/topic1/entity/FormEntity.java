package com.fpt.test.topic1.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author : Admin
 * @created : 12-Aug-21
 **/
@Entity
@Getter
@Setter
@Table(name = "form_tbl")
public class FormEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_id")
    private Long formId;

    @Column(name = "form_name")
    private String formName;

    @OneToMany(mappedBy = "formEntity", fetch = FetchType.LAZY)
    private Set<FormDetailEntity> formDetailEntity;
}
