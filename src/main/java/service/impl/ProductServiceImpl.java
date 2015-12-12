package service.impl;

import bo.BOProduct;
import dao.ProductDAO;
import dao.object.DBProduct;
import mapping.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProductService;

/**
 * Created by root on 12.12.15.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductMapper mapper;

    @Override
    public Long saveProduct(BOProduct product) {
        Long aLong = productDAO.saveProduct(mapper.map(product));
        return aLong;
    }

    @Override
    public BOProduct getById(Long id) {
        DBProduct dbProduct = productDAO.getProductById(id);
        return mapper.map(dbProduct);
    }

    @Override
    public BOProduct getBuBarcode(Long barcode) {
        DBProduct dbProduct = productDAO.getProductByBarcode(barcode);
        return mapper.map(dbProduct);
    }
}
