package com.label.po.image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ImageTaskRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 需求描述
     */
    private String name;
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
