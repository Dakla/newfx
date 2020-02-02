package sample.domains;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductFurnitureId implements Serializable {
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "furniture_id")
    private Long furnitureId;

    private ProductFurnitureId() { }

    public ProductFurnitureId(Long productId, Long furnitureId) {
        this.productId = productId;
        this.furnitureId = furnitureId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getFurnitureId() {
        return furnitureId;
    }

    public void setFurnitureId(Long furnitureId) {
        this.furnitureId = furnitureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductFurnitureId that = (ProductFurnitureId) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(furnitureId, that.furnitureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, furnitureId);
    }
}
