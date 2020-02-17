package sample.domains;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_units")
public class ProductUtils implements Serializable {
    @Id
    @ManyToOne
    private Product product;
    @Id
    private String name;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private Boolean defaultUnit;

    public ProductUtils() { }

    public ProductUtils(Product product, String name, Double amount, Boolean defaultUnit) {
        this.product = product;
        this.name = name;
        this.amount = amount;
        this.defaultUnit = defaultUnit;
    }

    public Product getCloth() {
        return product;
    }

    public void setCloth(Product cloth) {
        this.product = cloth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getDefaultUnit() {
        return defaultUnit;
    }

    public void setDefaultUnit(Boolean defaultUnit) {
        this.defaultUnit = defaultUnit;
    }
}
