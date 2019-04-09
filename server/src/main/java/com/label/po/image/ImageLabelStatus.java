package com.label.po.image;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ImageLabelStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户Id
     */
    private Integer userId;
    /**
     * 需求id
     */
    private Integer requirementId;
    /**
     * 是否完成
     */
    private Boolean finish;
    /**
     * 当前完成的标签
     */
    private Integer currentLabel;
}
