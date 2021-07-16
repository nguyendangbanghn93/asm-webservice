package com.t1908e.springclient.myService;

import com.t1908e.springclient.service.ProductService;
import com.t1908e.springclient.service.ProductServiceService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Bean
    public ProductService studentService(){
        ProductServiceService productSS = new ProductServiceService();
        ProductService service = productSS.getProductServicePort();
        return service;
    }
}
