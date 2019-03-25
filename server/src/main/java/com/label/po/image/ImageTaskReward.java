package com.label.po.image;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ImageTaskReward {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private Integer requirementId;

}
