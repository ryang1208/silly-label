package com.label.po.image;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class ImageDataset {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private Date uploadTime;

    private Integer uploadCount;

    private String description;

}
