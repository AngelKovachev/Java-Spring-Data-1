package test.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import test.exam.models.entities.Category;
import test.exam.models.entities.Item;
import test.exam.models.service.CategoryServiceModel;
import test.exam.models.service.ItemServiceModel;
import test.exam.models.view.ItemViewModel;
import test.exam.repository.ItemRepository;
import test.exam.service.CategoryService;
import test.exam.service.ItemService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository,
                           ModelMapper modelMapper,
                           CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }


    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        Item item = this.modelMapper.map(itemServiceModel, Item.class);

        Category category = this.categoryService
                .findByCategoryName(itemServiceModel.getCategory().getCategoryName());

        item.setCategory(category);

        this.itemRepository.saveAndFlush(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {

        return this.itemRepository
                .findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);
                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
                            item.getGender().name(), item.getCategory().getCategoryName().name()));
                    return itemViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(String id) {

        return this.itemRepository
                .findById(id)
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);
                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
                            item.getGender().name(), item.getCategory().getCategoryName().name()));
                    return itemViewModel;
                })
                .orElse(null);
    }

    @Override
    public void deleteById(String id) {
        this.itemRepository.deleteById(id);
    }
}
