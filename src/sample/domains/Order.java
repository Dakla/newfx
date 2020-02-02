package sample.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "ord")
public class Order implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    private Date date;
    @Column(nullable = false)
    private String phase;
    @OneToOne
    @JoinColumn(nullable = false)
    private User customer;
    @OneToOne
    @JoinColumn(nullable = false)
    private User manager;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderProduct> orderProducts;
    private Double price;

    public Order() {
    }

    public Order(Date date, String phase, User customer, User manager, Set<OrderProduct> orderProducts) {
        this.date = date;
        this.phase = phase;
        this.customer = customer;
        this.manager = manager;
        this.orderProducts = orderProducts;
    }

    public void addOrderProduct(Product product, int amount) {
        OrderProduct orderProduct = new OrderProduct(this, product, amount);
        orderProducts.add(orderProduct);
    }

    public void removeProduct(Product product) {
        for (Iterator<OrderProduct> iterator = orderProducts.iterator();
             iterator.hasNext(); ) {
            OrderProduct orderProduct = iterator.next();

            if (orderProduct.getOrder().equals(this) &&
                    orderProduct.getProduct().equals(product)) {
                iterator.remove();
                orderProduct.setOrder(null);
                orderProduct.setProduct(null);
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
