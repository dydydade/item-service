package hello.itemservice.domain.item;

import hello.itemservice.domain.Item;
import hello.itemservice.domain.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);
        //when
        Item savedItem = itemRepository.save(item);
        //then
        assertThat(itemRepository.findById(item.getId())).isSameAs(savedItem);
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 20);
        itemRepository.save(item1);
        itemRepository.save(item2);
        //when
        List<Item> itemList = itemRepository.findAll();
        //then
        assertThat(itemList.size()).isEqualTo(2);
        assertThat(itemList).contains(item1, item2);
    }

    @Test
    void updateItem() {
        //given
        Item item1 = new Item("itemA", 10000, 10);
        Item savedItem = itemRepository.save(item1);

        //when

        //then

    }
}
