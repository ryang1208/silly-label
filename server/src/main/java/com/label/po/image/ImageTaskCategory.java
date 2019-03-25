package com.label.po.image;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ImageTaskCategory {

    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 分类种类名字
     */
    private String categoryName;
}
