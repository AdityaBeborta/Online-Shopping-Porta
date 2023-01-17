package com.item.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.item.entity.Item;
import com.item.repository.ItemRepository;

@SpringBootTest
class ItemRepoTest {
	
	@Autowired
	private ItemRepository itemRepo;

	//get item by itemName
	@Test
	public void getItemByItemName() {
		Item item = this.itemRepo.findByName("laptop");
		Item item1 = new Item();
		item1.setId(item.getId());
		item1.setName("laptop");
		item1.setDescription("delll laptop");
		item1.setPrice(1000L);
		assertThat(item.getName()).isEqualTo(item1.getName());
		assertThat(item.getDescription()).isEqualTo(item1.getDescription());
		assertThat(item.getId()).isEqualTo(item1.getId());
		assertThat(item.getPrice()).isEqualTo(item1.getPrice());
	}
	
	//get all items
	@Test
	public void getAllItems() {
		List<Item> findAll = this.itemRepo.findAll();
		assertThat(findAll.size()).isGreaterThan(0);
	}
	
	//get item by item id
	@Test
	public void getItemByItemId() {
		Item item = this.itemRepo.findById(3L).get();
		assertThat(item.getId()).isEqualTo(3L);
		
	}
	//add an item
	@Test
	@Disabled
	public void saveItem() {
		Item item1 = new Item();
		item1.setName("junit Book");
		item1.setDescription("Do your Bestt");
		item1.setPrice(10L);
		Item save = this.itemRepo.save(item1);
		assertThat(save.getId()).isGreaterThan(0);
	}
	
	//update an item
	@Test
	@Disabled
	public void updateItem() {
		Item item = this.itemRepo.findById(154L).get();
		item.setName("junit Books");
		Item save = this.itemRepo.save(item);
		assertThat("junit Books").isEqualTo(save.getName());
	}
	
	
	
	

}