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
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 数据集id
     */
    private Integer datasetId;
    /**
     * 种类id
     */
    private Integer categoryId;
    /**
     * 分类标签
     */
    private String label;
    /**
     * 是否悬赏
     */
    private Boolean reward;
    /**
     * 是否审核通过
     */
    private Boolean verifyStatus;
}
