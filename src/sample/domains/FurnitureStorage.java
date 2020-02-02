package sample.domains;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "furniture_storage")
public class FurnitureStorage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long party;
    @Id
    @OneToOne
    private Furniture furniture;
    @Column(nullable = false)
    private int amount;

    public FurnitureStorage() {
    }

    public FurnitureStorage(Furniture furniture, int amount) {
        this.furniture = furniture;
        this.amount = amount;
    }

    public Long getParty() {
        return party;
    }

    public void setParty(Long party) {
        this.party = party;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
