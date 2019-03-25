package com.label.po.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class UserRole {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer userId;

    private Integer roleId;
}
