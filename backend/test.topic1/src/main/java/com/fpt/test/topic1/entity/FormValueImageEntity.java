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
@Table(name = "form_value_image_tbl")
public class FormValueImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_value_image_id")
    private Long formValueImageId;

    @ManyToOne
    @JoinColumn(name = "form_value_id")
    private FormValueEntity formValueEntity;

    @Column(name = "image_path")
    private String imagePath;
}
