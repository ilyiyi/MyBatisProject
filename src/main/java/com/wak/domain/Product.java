package com.wak.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wak
 * 实体类
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseDomain {
    private Long id;

    private String name;

    private Double price;

    private String remark;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;
}