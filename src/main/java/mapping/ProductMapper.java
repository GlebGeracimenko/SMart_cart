package mapping;

import bo.BOProduct;
import dao.object.DBProduct;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by root on 12.12.15.
 */
@Component
public class ProductMapper {

    private Mapper mapper;

    @PostConstruct
    public void init() {
        mapper = new DozerBeanMapper();
    }

    public DBProduct map(BOProduct product){
        if (product == null) {
            return null;
        }
        return mapper.map(product, DBProduct.class);
    }

    public BOProduct map(DBProduct product) {
        if (product == null) {
            return null;
        }
        return mapper.map(product, BOProduct.class);
    }

}
