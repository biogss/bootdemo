package org.wang.bootdemo.org.wang.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wang.bootdemo.BootdemoApplication;
import org.wang.bootdemo.model.Product;
import org.wang.bootdemo.service.ProductService;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ProductServiceTest
 * @Description 产品服务类的测试类
 * @Author wangHao
 * @DATE 2020/1/5 15:49
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootdemoApplication.class)
public class ProductServiceTest {

    private ProductService productService;

    private Product product;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @Autowired
    public void setProduct(Product product) {
        this.product = product;
    }
    @Test
    public void execute(){
        product.setProductCode("T03");
        product.setProductName("book3");
        product.setProductDesc("测试添加产品3.1");
        product.setProductPrice(50.00);
        product.setProductStatus("0");
        product.setProductType("book");
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        int row = productService.addProduct(product);
        System.out.println(row);
    }

    @Test
    public void execute2(){
        Product product = productService.getProductByProductId(11);
        System.out.println(product.toString());
    }

    @Test
    public void execute3(){
        List<Product> products = productService.getProductByProductCode("T03");
        if (products != null && products.size() > 0){
            for (Product product : products){
                System.out.println(product.toString());
            }
        }
    }

    @Test
    public void execute4(){
        product.setProductId(1);
        product.setProductImg("fileupload/20201010.png");
        product.setProductName("effective java");
        product.setUpdateTime(new Date());
        int row = productService.updateProductByProductId(product);
    }

    @Test
    public void execute5(){
        int row = productService.daleteProductByProductId(4);
    }

    @Test
    public void execute6(){
        List<Product> productList = productService.getProductListByProductName("测试02");
        if (productList != null && productList.size() > 0){
            for (Product product : productList){
                System.out.println(product.toString());
            }
        }
    }
}
