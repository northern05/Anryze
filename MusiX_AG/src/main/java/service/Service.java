package service;

import dao.ProductDao;
import models.Product;

import java.util.List;

public class Service {
    private ProductDao productDao = new ProductDao();

    public Product findProduct(int id){
        return productDao.findById(id);
    }

    public void saveProduct(Product product){
        productDao.save(product);
    }

    public void deleteProduct(Product product){
        productDao.delete(product);
    }

    public void updateProduct(Product product){
        productDao.update(product);
    }

    public List<Product> findAllProducts(){
        return productDao.findAll();
    }
}
