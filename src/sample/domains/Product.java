package sample.domains;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double width;
    @Column(nullable = false)
    private Double height;
    private String image;
    private String comment;
    @ManyToMany
    private List<Cloth> cloths;
    @OneToMany(mappedBy = "furniture", cascade = CascadeType.ALL)
    private Set<ProductFurniture> furnitures;

    public Product() {
    }

    public Product(String name, Double width, Double height, String image, String comment, List<Cloth> cloths, Set<ProductFurniture> furnitures) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.image = image;
        this.comment = comment;
        this.cloths = cloths;
        this.furnitures = furnitures;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Cloth> getCloths() {
        return cloths;
    }

    public void setCloths(List<Cloth> cloths) {
        this.cloths = cloths;
    }

    public Set<ProductFurniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(Set<ProductFurniture> furnitures) {
        this.furnitures = furnitures;
    }

    public void addFurnitures(Furniture furniture, String place, int amount) {
        ProductFurniture productFurniture = new ProductFurniture(furniture, this, place, amount);
        furnitures.add(productFurniture);
    }
}
