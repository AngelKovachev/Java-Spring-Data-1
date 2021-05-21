package test.exam.service;

import test.exam.models.service.ItemServiceModel;
import test.exam.models.view.ItemViewModel;

import java.util.List;

public interface ItemService {

    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(String id);

    void deleteById(String id);
}
