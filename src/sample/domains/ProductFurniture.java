package sample.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_furniture")
public class ProductFurniture {
    @EmbeddedId
    private ProductFurnitureId id;
    @ManyToOne
    @MapsId("furnitureId")
    private Furniture furniture;
    @ManyToOne
    @MapsId("productId")
    private Product product;
    @Column(nullable = false)
    private String place;
    @Column(nullable = false)
    private int amount;
    private Double height;
    private Double width;
    private Double rotation;

    private ProductFurniture() { }

    public ProductFurniture(Furniture furniture, Product product, String place, int amount) {
        this.furniture = furniture;
        this.product = product;
        this.place = place;
        this.amount = amount;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getRotation() {
        return rotation;
    }

    public void setRotation(Double rotation) {
        this.rotation = rotation;
    }

    public ProductFurnitureId getId() {
        return id;
    }

    public void setId(ProductFurnitureId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductFurniture that = (ProductFurniture) o;
        return Objects.equals(furniture, that.furniture) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(furniture, product);
    }
}
