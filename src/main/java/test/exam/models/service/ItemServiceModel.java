package test.exam.models.service;

import org.hibernate.validator.constraints.Length;
import test.exam.models.entities.Category;
import test.exam.models.entities.Gender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

public class ItemServiceModel extends BaseServiceModel{

    private String name;
    private String description;
    private BigDecimal price;
    private CategoryServiceModel category;
    private GenderServiceModel gender;

    public ItemServiceModel() {
    }

    @Length(min = 3, message = "Item name must be more than three characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 3, message = "Description length must be more than three characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DecimalMin(value = "0", message = "price can not be negative")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //@Enumerated(EnumType.STRING)
    public CategoryServiceModel getCategory() {
        return category;
    }

    public void setCategory(CategoryServiceModel category) {
        this.category = category;
    }

    //@Enumerated(EnumType.STRING)
    public GenderServiceModel getGender() {
        return gender;
    }

    public void setGender(GenderServiceModel gender) {
        this.gender = gender;
    }
}
