package test.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.exam.models.entities.Category;
import test.exam.models.entities.CategoryName;
import test.exam.models.service.CategoryServiceModel;
import test.exam.repository.CategoryRepository;
import test.exam.service.CategoryService;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void fillRepository() {
        if (this.categoryRepository.count() == 0){
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        this.categoryRepository
                                .save(new Category(categoryName,
                                        String.format("Description for %s",categoryName.name() )));
                    });
        }
    }

    /*@Override
    public CategoryServiceModel findByCategoryName(CategoryName categoryName) {
        return this.categoryRepository.findByCategoryName(categoryName)
                .map(category -> this.modelMapper.map(category, CategoryServiceModel.class))
                .orElse(null);
    }*/

    @Override
    public Category findByCategoryName(CategoryName categoryName) {
        return this.categoryRepository.findByCategoryName(categoryName);
    }


}
