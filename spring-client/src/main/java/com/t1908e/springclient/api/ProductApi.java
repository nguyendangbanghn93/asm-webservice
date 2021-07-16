package com.t1908e.springclient.api;

import com.t1908e.springclient.service.Product;
import com.t1908e.springclient.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductApi {
    @Autowired
    ProductService productService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @RequestMapping(value = "/{productID}",method = RequestMethod.PUT)
    public Product sellProduct(@PathVariable int productID,@RequestBody Product product){
        return productService.sellProduct(productID,product.getQuantity());
    }
}
