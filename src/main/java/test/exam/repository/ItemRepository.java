package test.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.exam.models.entities.Item;
import test.exam.models.view.ItemViewModel;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

}
