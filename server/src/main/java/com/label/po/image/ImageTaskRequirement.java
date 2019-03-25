package com.label.po.image;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ImageTaskRequirement {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private Integer datasetId;

    private Integer categoryId;

    private String label;

    private Boolean reward;

    private Boolean verifyStatus;
}
