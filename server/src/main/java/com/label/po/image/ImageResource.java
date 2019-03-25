package com.label.po.image;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ImageResource {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer datasetId;

    private String url;
}
