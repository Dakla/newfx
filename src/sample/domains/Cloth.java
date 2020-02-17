package sample.domains;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double width;
    @Column(nullable = false)
    private Double height;
    @Column(nullable = false)
    private Double price;
    private String color;
    private String picture;
    private String image;
    private String comp;
    @OneToMany
    @JoinColumn(nullable = false)
    private Set<ClothUnits> units;
    @ManyToMany
    private List<Product> product;

    public Cloth() {
    }

    public Cloth(String name, Double width, Double height, Double price, Set<ClothUnits> units) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.price = price;
        this.units = units;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Set<ClothUnits> getUnits() {
        return units;
    }

    public void setUnits(Set<ClothUnits> units) {
        this.units = units;
    }
}
