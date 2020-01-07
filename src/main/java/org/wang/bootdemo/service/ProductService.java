package org.wang.bootdemo.service;

import org.wang.bootdemo.model.Product;

import java.util.List;
import java.util.Queue;

public interface ProductService {

   /**
    * @Description 添加产品
    * @Author wangHao
    * @Date 2020/1/5 14:49
    * @params product
    * @return int
    */
   int addProduct(Product product);

   /**
    * @description 根据产品编号获取产品信息
    * @author wangHao
    * @date 2020/1/5 16:42
    * @params productId
    * @return product
    */
   Product getProductByProductId(int productId);
   
   /**
    * @description 根据产品代码查询产品信息
    * @author wangHao
    * @date 2020/1/5 17:37
    * @param [productCode]
    * @return java.util.List<org.wang.bootdemo.model.Product>
    */
   List<Product> getProductByProductCode(String productCode);

   /**
    * @description 修改产品信息
    * @author wangHao
    * @date 2020/1/5 19:02
    * @param [productId]
    * @return int
    */
   int updateProductByProductId(Product product);

   /**
    * @description 删除产品
    * @author wangHao
    * @date 2020/1/5 19:27
    * @param [productId]
    * @return int
    */
   int daleteProductByProductId(int productId);

   /**
    * @description 根据产品名称查询产品信息
    * @author wangHao
    * @date 2020/1/7 22:48
    * @param [productName]
    * @return java.util.List<org.wang.bootdemo.model.Product>
    */
   List<Product> getProductListByProductName(String productName);

}
