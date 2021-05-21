package test.exam.service;

import test.exam.models.entities.Item;
import test.exam.models.service.UserServiceModel;

public interface UserService {

    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);

    Item findItem(String username, String id);
}
