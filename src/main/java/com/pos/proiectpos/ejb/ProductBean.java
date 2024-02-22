package com.pos.proiectpos.ejb;

import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.entities.Product;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class ProductBean {
    private static final Logger LOG = Logger.getLogger(ProductBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<ProductDto> findAllProducts(){
        LOG.info("findAllProducts");
        try{
            TypedQuery<Product> typedQuery = entityManager.createQuery("Select p FROM Product p", Product.class);
            List<Product> products = typedQuery.getResultList();
            return copyProductsToDto(products);
        }catch(Exception ex){
            throw new EJBException(ex);
        }
    }

    public List<ProductDto> copyProductsToDto(List<Product> products){
        List<ProductDto> result = new ArrayList<>();
        for(Product p: products){
            ProductDto pdto = new ProductDto(p.getId(),p.getProduct_name(),p.getStock(),p.getPrice());
            result.add(pdto);
        }
        return result;
    }
}
