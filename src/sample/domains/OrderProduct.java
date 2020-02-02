package sample.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ord_product")
public class OrderProduct {
    @EmbeddedId
    private OrderProductId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    private Product product;
    @Column(nullable = false)
    private int amount;

    private OrderProduct() {
    }

    public OrderProduct(Order order, Product product, int amount) {
        this.order = order;
        this.product = product;
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public OrderProductId getId() {
        return id;
    }

    public void setId(OrderProductId id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProduct that = (OrderProduct) o;
        return Objects.equals(order, that.order) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
