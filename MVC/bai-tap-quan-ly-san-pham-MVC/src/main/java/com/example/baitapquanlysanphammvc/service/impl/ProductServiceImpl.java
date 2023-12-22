package com.example.baitapquanlysanphammvc.service.impl;

import com.example.baitapquanlysanphammvc.model.Product;
import com.example.baitapquanlysanphammvc.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<String, Product> products;
    static {
        products = new HashMap<>();
        products.put("1",new Product("1","Keo",10000));
        products.put("2",new Product("2","Keo2",20000));
        products.put("3",new Product("3","Keo3",30000));
    }
    @Override
    public void addProduct(Product product) {
        if(!products.containsKey(product.getId())){
            products.put(product.getId(), product);
        }

    }

    @Override
    public void deleteProduct(String id) {
        products.remove(id);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>();
        for(Map.Entry<String, Product> x : products.entrySet()){
            if(x.getValue().getName().contains(name)){
                list.add(x.getValue());
            }
        }
        if(list.isEmpty())
        return null;
        return list;
    }

    @Override
    public Product findById(String id) {
        return products.get(id);
    }

    public List<Product> findAll(){
        return new ArrayList<>(products.values());
    }
}
