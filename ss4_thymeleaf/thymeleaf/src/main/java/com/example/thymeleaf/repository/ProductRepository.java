package com.example.thymeleaf.repository;

import com.example.thymeleaf.model.ProductModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<ProductModel> productModelList = new ArrayList<>();

    static {
        productModelList.add(new ProductModel(1, "Acer", 20.2, "Pink"));
        productModelList.add(new ProductModel(2, "Dell", 15.6, "Black"));
        productModelList.add(new ProductModel(3, "Msi", 14.9, "Red"));
        productModelList.add(new ProductModel(4, "Asus", 30.3, ""));
    }

    @Override
    public List<ProductModel> getAll() {
        return productModelList;
    }

    @Override
    public void save(ProductModel productModel) {
        productModelList.add(productModel);
    }

    @Override
    public ProductModel findById(Integer id) {
        for (int i = 0; i <= productModelList.size(); i++) {
            if (id.equals(productModelList.get(i).getId())) {
                return productModelList.get(i);
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        for (int i = 0; i <= productModelList.size(); i++) {
            if (id.equals(productModelList.get(i).getId())) {
                productModelList.remove(i);
                break;
            }
        }
    }

    @Override
    public List<ProductModel> search(String name) {
        List<ProductModel>productModels=new ArrayList<>();
       for (ProductModel p: productModelList){
           if (p.getName().equals(name)){
               productModels.add(p);
           }
       }
        return productModels;
    }

    @Override
    public void updateProductModel(ProductModel productModel) {
        for (ProductModel p : productModelList) {
            if (p.getId().equals(productModel.getId())) {
                p.setName(productModel.getName());
                p.setPrice(productModel.getPrice());
                p.setDescribe(productModel.getDescribe());
            }
        }
    }
}
