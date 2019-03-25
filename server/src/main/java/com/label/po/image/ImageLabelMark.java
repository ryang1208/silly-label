package com.label.po.image;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ImageLabelMark {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer datasetId;

    private Integer imageId;

    private String imageUrl;

    private String labelContent;
}
