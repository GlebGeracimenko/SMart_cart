package dao.object;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by root on 12.12.15.
 */
@Entity
@Table(name = DBProduct.IDENTIFIER, uniqueConstraints = @UniqueConstraint(columnNames = {"barcode"}))
public class DBProduct {
    public static final String IDENTIFIER = "product";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "barcode", unique = true)
    private long barcode;
    private double price;
    private String name;
    private String description;
    @Column(name = "start_product")
    private Timestamp startProduct;
    @Column(name = "end_product")
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
