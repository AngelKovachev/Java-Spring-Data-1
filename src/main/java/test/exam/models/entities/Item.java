package test.exam.models.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item extends BaseEntity{

    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private Gender gender;

    public Item() {
    }

    @Column(name = "name", unique = true)
    @Length(min = 3, message = "Item name must be more than three characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    @Length(min = 3, message = "Description length must be more than three characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price")
    //@Size(min = 0, message = "price can not be negative")
    @DecimalMin(value = "0", message = "price can not be negative")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
