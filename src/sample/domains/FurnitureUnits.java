package sample.domains;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "furniture_units")
public class FurnitureUnits implements Serializable {
    @Id
    @ManyToOne
    private Furniture product;
    @Id
    private String name;
    @Column(nullable = false)
    private Double amount;
}
