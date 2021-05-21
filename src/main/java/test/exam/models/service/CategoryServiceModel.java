package test.exam.models.service;

import test.exam.models.entities.CategoryName;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CategoryServiceModel {

    private CategoryName categoryName;
    private String description;

    public CategoryServiceModel() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
