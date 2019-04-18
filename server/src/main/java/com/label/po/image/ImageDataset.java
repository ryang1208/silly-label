package com.label.po.image;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class ImageDataset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 上传时间
     */
    private Date uploadTime;
    /**
     * 上传数量
     */
    private Integer uploadCount;
    /**
     * 描述
     */
    private String description;

}
