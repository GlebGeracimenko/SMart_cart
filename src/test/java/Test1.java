import dao.ProductDAO;

import dao.object.DBProduct;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by root on 12.12.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testAppContext.xml"})
public class Test1 {

    @Autowired
    private ProductDAO dao;

    @Autowired
    private EntityManagerFactory factory;

    //@Before
    public void clear() {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        //entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE " + DBProduct.IDENTIFIER, DBProduct.class).executeUpdate();
        //entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Test
    public void test() {
        DBProduct product = new DBProduct();
        product.setBarcode(123L);
        product.setDescription("test");
        product.setName("test");
        product.setPrice(12.08);
        Timestamp timestamp = new Timestamp(new Date().getTime());
        timestamp.setNanos(0);
        product.setStartProduct(timestamp);
        product.setEndProduct(timestamp);
        dao.saveProduct(product);
        DBProduct getProduct = dao.getProductById(product.getId());
        Assert.assertNotNull(getProduct);
        check(product, getProduct);
        DBProduct getProduct1 = dao.getProductByBarcode(product.getBarcode());
        Assert.assertNotNull(getProduct1);
        check(product, getProduct1);
    }

    private void check(DBProduct product1, DBProduct product2) {
        Assert.assertThat(product1.getId(), CoreMatchers.equalTo(product2.getId()));
        Assert.assertThat(product1.getBarcode(), CoreMatchers.equalTo(product2.getBarcode()));
        Assert.assertThat(product1.getName(), CoreMatchers.equalTo(product2.getName()));
        Assert.assertThat(product1.getDescription(), CoreMatchers.equalTo(product2.getDescription()));
        Assert.assertThat(product1.getPrice(), CoreMatchers.equalTo(product2.getPrice()));
        Assert.assertThat(product1.getStartProduct(), CoreMatchers.equalTo(product2.getStartProduct()));
        Assert.assertThat(product1.getEndProduct(), CoreMatchers.equalTo(product2.getEndProduct()));
    }

}
