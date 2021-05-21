package test.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.exam.models.entities.Item;
import test.exam.models.entities.User;
import test.exam.models.service.UserServiceModel;
import test.exam.repository.ItemRepository;
import test.exam.repository.UserRepository;
import test.exam.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ItemRepository itemRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,
                           ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.itemRepository = itemRepository;
    }

    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {
        User user = this.modelMapper
                .map(userServiceModel, User.class);
        this.userRepository.saveAndFlush(user);
        return this.modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        //taka ne raboti
        /*return this.modelMapper
                .map(this.userRepository.findByUsername(username)
                        .orElse(null), UserServiceModel.class);*/

        return this.userRepository
                .findByUsername(username)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public Item findItem(String username, String id) {
       /* User user = this.userRepository.findByUsername(username).orElse(null);
        if(user != null){
            List<Item> userItems = user.getItems();
            if(userItems.size() > 0){
                for (Item item: userItems){
                    if(item.getId().equals(id)){
                        return item;
                    }
                }
            }
        }*/
        return null;
    }
}
