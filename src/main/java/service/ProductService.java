package service;

import bo.BOProduct;

/**
 * Created by root on 12.12.15.
 */
public interface ProductService {

    Long saveProduct(BOProduct product);

    BOProduct getById(Long id);

    BOProduct getBuBarcode(Long barcode);

}
