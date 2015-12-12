package dao;

import dao.object.DBProduct;

/**
 * Created by root on 12.12.15.
 */
public interface ProductDAO {

    Long saveProduct(DBProduct product);

    DBProduct getProductById(Long id);

    DBProduct getProductByBarcode(Long barode);

}
