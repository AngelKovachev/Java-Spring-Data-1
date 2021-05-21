package test.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.exam.models.entities.Category;
import test.exam.models.entities.CategoryName;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Category findByCategoryName(CategoryName categoryName);
}
