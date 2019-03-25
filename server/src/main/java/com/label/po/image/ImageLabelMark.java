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
    /**
     * 数据集id
     */
    private Integer datasetId;
    /**
     * 图片id
     */
    private Integer imageId;
    /**
     * 图片链接
     */
    private String imageUrl;
    /**
     * 打标内容
     */
    private String labelContent;
}
