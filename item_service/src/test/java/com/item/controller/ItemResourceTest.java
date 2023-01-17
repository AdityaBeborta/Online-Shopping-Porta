package com.item.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.item.payload.ItemDTO;
import com.item.service.ItemService;
import com.item.util.ApiResponse;

@SpringBootTest(classes = { ItemResourceTest.class })
class ItemResourceTest {

	@Mock
	private ItemService itemService;

	@InjectMocks
	private ItemController itemController;

	private List<ItemDTO> items;

	private ItemDTO item;

	// junit for all items
	@Test
	@Order(1)
	public void getAllItem_Postitive() {
		items = new ArrayList<ItemDTO>();
		items.add(new ItemDTO(1, "doll", "playing toys", 100L));
		items.add(new ItemDTO(2, "cds", "best of salman ali", 1000L));
		when(itemService.all()).thenReturn(items);
		List<ItemDTO> allItems = this.itemController.all();
		
		assertThat(2).isEqualTo(allItems.size());

	}
	@Test
	@Order(2)
	public void getAllItem_Negative() {
		items = new ArrayList<ItemDTO>();
		items.add(new ItemDTO(1, "doll", "playing toys", 100L));
		items.add(new ItemDTO(2, "cds", "best of salman ali", 1000L));
		when(itemService.all()).thenReturn(items);
		List<ItemDTO> allItems = this.itemController.all();
		
		assertThat(3).isEqualTo(allItems.size());

	}

	@Test
	@Order(3)
	public void getItemByItemName_Positive() {
		item = new ItemDTO(1, "doll", "playing toys", 100L);
		String itemName = "doll";
		when(itemService.get(itemName)).thenReturn(item);
		ItemDTO particularItem = this.itemController.get(itemName);

		assertThat(item).isEqualTo(particularItem);
	}
	
	@Test
	@Order(4)
	public void getItemByItemName_Negative() {
		item = new ItemDTO(1, "doll", "playing toys", 100L);
		String itemName = "Bingo";
		when(itemService.get(itemName)).thenReturn(item);
		ItemDTO particularItem = this.itemController.get(itemName);

		assertThat(itemName).isEqualTo(particularItem.getName());
	}

	@Test
	@Order(5)
	public void addItems() {
		item = item = new ItemDTO(1, "doll", "playing toys", 100L);
		when(itemService.save(item)).thenReturn(item);
		ItemDTO addedItem = this.itemController.add(item);
		assertThat(item).isEqualTo(addedItem);

	}
	
	@Test
	@Order(6)
	public void updateItem() {
		item = new ItemDTO(1, "doll", "playing toys", 100L);
		long id = 1;
		String name = "dummy testing";
		when(itemService.update(id, item)).thenReturn(item);
		item.setName(name);
		ItemDTO updatedItem = itemController.put(id, item);
		assertThat(item).isEqualTo(updatedItem);
	}

	@Test
	@Order(7)
	public void deleteById() {
		item = item = new ItemDTO(1L, "doll", "playing toys", 100L);
		long id = 1;
		ApiResponse apiResponse = itemController.delete(id);
		assertThat("true").isEqualTo(apiResponse.getSuccess().toString().trim());

	}
	
	@Test
	@Order(8)
	public void deleteById_Negative() {
		item = item = new ItemDTO(1L, "doll", "playing toys", 100L);
		long id = 1;
		ApiResponse apiResponse = itemController.delete(id);
		assertThat("false").isEqualTo(apiResponse.getSuccess().toString().trim());

	}

}