package com.example.microcommon.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Product
 * @Description 商品实体类
 * @Author Wenbo Li
 * @Date 17/9/2022 下午 8:16
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@TableName("tb_product")
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格
     */
    private Double price;

    /**
     * 折扣价
     */
    private Double discountPrice;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 商品分类id
     */
    private Long typeId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Boolean deleteFlag = false;

    /**
     * 是否上架
     */
    private Boolean saleFlag = true;
}
