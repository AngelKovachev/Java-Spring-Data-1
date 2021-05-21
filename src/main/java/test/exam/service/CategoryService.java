package test.exam.service;

import test.exam.models.entities.Category;
import test.exam.models.entities.CategoryName;
import test.exam.models.service.CategoryServiceModel;

import java.util.Optional;

public interface CategoryService {
    void fillRepository();

    Category findByCategoryName(CategoryName categoryName);
}
