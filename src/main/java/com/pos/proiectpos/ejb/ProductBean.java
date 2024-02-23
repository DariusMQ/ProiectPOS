package com.pos.proiectpos.ejb;

import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.common.ProductPhotoDto;
import com.pos.proiectpos.entities.Product;
import com.pos.proiectpos.entities.ProductPhoto;
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

    public void createProduct(String productName,Float price,Long stock){
        LOG.info("createProduct");

        Product product = new Product();
        product.setProduct_name(productName);
        product.setPrice(price);
        product.setStock(stock);

        entityManager.persist(product);
    }

    public ProductDto findById(Long productId){
        for(ProductDto pdto: findAllProducts()){
            if(productId.equals(pdto.getId()))
                return pdto;
        }
        return null;
    }

    public void updateProduct(Long productId,String productName,Long stock,Float price){
        LOG.info("updateProduct");

        Product product = entityManager.find(Product.class, productId);
        product.setProduct_name(productName);
        product.setStock(stock);
        product.setPrice(price);

    }

    public void deleteById(Long productId){
        LOG.info("deleteProduct");

        Product product = entityManager.find(Product.class, productId);

        entityManager.remove(product);
    }

    public void addPhotoToProduct(Long productId, String filename, String fileType, byte[] fileContent) {
        LOG.info("addPhotoToProduct");
        ProductPhoto photo = new ProductPhoto();
        photo.setFilename(filename);
        photo.setFileType(fileType);
        photo.setFileContent(fileContent);
        Product product = entityManager.find(Product.class, productId);
        if (product.getPhoto() != null) {
            entityManager.remove(product.getPhoto());
        }
        product.setPhoto(photo);
        photo.setProduct(product);
        entityManager.persist(photo);
    }
    public ProductPhotoDto findPhotoByProductId(Integer productId) {
        List<ProductPhoto> photos = entityManager
                .createQuery("SELECT p FROM ProductPhoto p where p.product.id = :id", ProductPhoto.class)
                .setParameter("id", productId)
                .getResultList();
        if (photos.isEmpty()) {
            return null;
        }
        ProductPhoto photo = photos.get(0); // the first element
        return new ProductPhotoDto(photo.getId(), photo.getFilename(), photo.getFileType(),
                photo.getFileContent());
    }
}
