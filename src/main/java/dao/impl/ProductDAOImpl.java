package dao.impl;

import dao.ProductDAO;
import dao.object.DBProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Created by root on 12.12.15.
 */
@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Long saveProduct(DBProduct product) {
        if (product != null) {
            if (product.getId() != null) {
                product.setId(null);
            }
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
            return product.getId();
        }
        return null;
    }

    @Override
    public DBProduct getProductById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        DBProduct product = entityManager.find(DBProduct.class, id);
        transaction.commit();
        return product;
    }

    @Override
    public DBProduct getProductByBarcode(Long barcode) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String request = String.format("SELECT p FROM %s p WHERE p.barcode = %d", DBProduct.class.getName(), barcode);
        DBProduct product = entityManager.createQuery(request, DBProduct.class).getSingleResult();
        return product;
    }
}
