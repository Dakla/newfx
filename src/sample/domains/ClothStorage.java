package sample.domains;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cloth_storage")
public class ClothStorage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    @OneToOne
    private Cloth cloth;
    @Column(nullable = false)
    private Double width;
    @Column(nullable = false)
    private Double height;

    public ClothStorage() {
    }

    public ClothStorage(Cloth cloth, Double width, Double height) {
        this.cloth = cloth;
        this.width = width;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
