package com.label.po.image;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ImageLabelStatus {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private Integer requirementId;

    private Boolean finish;

    private Integer currentLabel;
}
