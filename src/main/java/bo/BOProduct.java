package bo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Timestamp;

/**
 * Created by root on 12.12.15.
 */
@XmlRootElement
public class BOProduct {

    private Long id;
    private long barcode;
    private double price;
    private String name;
    private String description;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Timestamp startProduct;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Timestamp endProduct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStartProduct() {
        return startProduct;
    }

    public void setStartProduct(Timestamp startProduct) {
        this.startProduct = startProduct;
    }

    public Timestamp getEndProduct() {
        return endProduct;
    }

    public void setEndProduct(Timestamp endProduct) {
        this.endProduct = endProduct;
    }
}
