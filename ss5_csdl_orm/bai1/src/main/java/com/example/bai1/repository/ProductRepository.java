package com.example.bai1.repository;

import com.example.bai1.model.ProductModel;

import org.springframework.stereotype.Repository;


import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

import static com.example.bai1.repository.BaseRepository.entityManager;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<ProductModel> getAll() {
        TypedQuery<ProductModel> typedQuery = BaseRepository.entityManager.createQuery("SELECT k FROM ProductModel AS k", ProductModel.class);
        return typedQuery.getResultList();
    }

    @Override
    public boolean save(ProductModel productModel) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(productModel);
        entityTransaction.commit();
        return true;
    }


    @Override
    public ProductModel findById(Integer id) {
        ProductModel productModel = entityManager.find(ProductModel.class, id);
        return productModel;
    }

    @Override
    public boolean delete(Integer id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(findById(id));
        entityTransaction.commit();
        return true;
    }

    @Override
    public List<ProductModel> search(String name) {

        TypedQuery<ProductModel> productModel = entityManager.createQuery("SELECT k FROM ProductModel AS k WHERE  k.name LIKE :names", ProductModel.class);
        productModel.setParameter("names", "%" + name.trim() + "%");
        return productModel.getResultList();
    }

    @Override
    public void updateProductModel(ProductModel productModel) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(productModel);
        entityTransaction.commit();
    }
}
