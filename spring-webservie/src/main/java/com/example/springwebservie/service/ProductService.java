package com.example.springwebservie.service;

import com.example.springwebservie.entity.Product;
import com.example.springwebservie.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@Component(value = "productService")
@WebService
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @WebMethod
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @WebMethod
    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    @WebMethod
    public Product sellProduct(int productId,int quantity){
        Optional<Product> existProduct = productRepository.findById(productId);
        if(!existProduct.isPresent()){
            return null;
        }
        Product product = existProduct.get();
        product.setQuantity(quantity);
        return productRepository.save(product);
    }
}
