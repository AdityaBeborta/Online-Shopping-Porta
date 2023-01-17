package com.item.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.item.entity.Item;
import com.item.payload.ItemDTO;
import com.item.repository.ItemRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ItemServiceTest {

	@Mock
	private ItemRepository itemRepository;
	@InjectMocks
	private ItemService itemService;
	@Mock
	private ModelMapper modelMapper;

	public Item item;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	void getAllItems() {
		List<Item> list = new ArrayList<>();
		Item item1 = new Item();
		item1.setId(1L);
		item1.setName("books");
		item1.setDescription("core java");
		item1.setPrice(1000L);
		Item item2 = new Item();
		item2.setId(2L);
		item2.setName("cloths");
		item2.setDescription("Tshirt java");
		item2.setPrice(1000L);
		list.add(item1);
		list.add(item2);
		when(itemRepository.findAll()).thenReturn(list);
		// test
		List<ItemDTO> itemDto = itemService.all();

		assertThat(2).isEqualTo(itemDto.size());

	}

	@Test
	public void addItems() {
		Item item1 = new Item();
		item1.setId(1L);
		item1.setName("books");
		item1.setDescription("core java");
		item1.setPrice(1000L);
		ItemDTO map = this.modelMapper.map(item1, ItemDTO.class);
		ItemDTO savedItem = itemService.save(map);
		Item save = this.itemRepository.save(item1);
		ItemDTO map2 = this.modelMapper.map(save, ItemDTO.class);
		assertThat(map2).isEqualTo(savedItem);

	}

	@Test
	public void getItemByItemNameNegative() {

		Item item = new Item();
		item.setId(1L);
		item.setName("Dolll");
		item.setDescription("core java");
		item.setPrice(1000L);
		String itemName = "books";
		when(itemRepository.findByName(itemName)).thenReturn(item);
		assertNull(itemService.get(itemName));

	}

}