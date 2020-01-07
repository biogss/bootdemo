package org.wang.bootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wang.bootdemo.mapper.ProductMapper;
import org.wang.bootdemo.model.Product;
import org.wang.bootdemo.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductMapper productMapper;

    @Autowired
    public void setProductMapper(ProductMapper productMapper){
        this.productMapper = productMapper;
    }

    @Override
    public int addProduct(Product product) {
        return productMapper.insert(product);
    }
    @Override
    public Product getProductByProductId(int productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<Product> getProductByProductCode(String productCode) {
        return productMapper.getProductByProductCode(productCode);
    }

    @Override
    public int updateProductByProductId(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public int daleteProductByProductId(int productId) {
        return productMapper.deleteByPrimaryKey(productId);
    }
}
