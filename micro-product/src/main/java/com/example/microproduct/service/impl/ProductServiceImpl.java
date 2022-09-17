package com.example.microproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.microcommon.pojo.Product;
import com.example.microproduct.mapper.ProductMapper;
import com.example.microproduct.service.ProductService;

/**
 * @ClassName ProductServiceImpl
 * @Description 商品service实现类
 * @Author Wenbo Li
 * @Date 17/9/2022 下午 8:47
 * @Version 1.0
 */
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
