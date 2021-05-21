package test.exam.models.binding;

import org.hibernate.validator.constraints.Length;
import test.exam.models.entities.Category;
import test.exam.models.entities.CategoryName;
import test.exam.models.entities.Gender;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ItemAddBindingModem {

    private String name;
    private String description;
    private CategoryName category;
    private Gender gender;
    private BigDecimal price;

    public ItemAddBindingModem() {
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

    @NotNull(message = "Enter valid category name")
    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }

    //@Length(min = 3, message = "Gender length must be more than three characters")
    @NotNull(message = "Enter valid gender name")
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @DecimalMin(value = "0", message = "price can not be negative")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
