package sample.domains;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cloth_units")
public class ClothUnits implements Serializable {
    @Id
    @ManyToOne
    private Cloth cloth;
    @Id
    private String name;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private Boolean defaultUnit;

    public ClothUnits() { }

    public ClothUnits(Cloth cloth, String name, Double amount, Boolean defaultUnit) {
        this.cloth = cloth;
        this.name = name;
        this.amount = amount;
        this.defaultUnit = defaultUnit;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
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
