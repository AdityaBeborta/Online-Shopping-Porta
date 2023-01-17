package com.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.entity.Item;
import com.item.exception.ResourceNotFoundException;
import com.item.payload.ItemDTO;
import com.item.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ItemRepository itemRepository;

	public List<ItemDTO> all() {
		return itemRepository.findAll().stream().map(item -> modelMapper.map(item, ItemDTO.class))
				.collect(Collectors.toList());
	}

	public ItemDTO save(ItemDTO itemDTO) {
		Item item = itemRepository.save(modelMapper.map(itemDTO, Item.class));
		return modelMapper.map(item, ItemDTO.class);
	}

	public ItemDTO get(String itemName) {
		Item findByName = itemRepository.findByName(itemName);
		if(findByName==null) {
			throw new ResourceNotFoundException("item", "item name", itemName);
		}
		return modelMapper.map(itemRepository.findByName(itemName), ItemDTO.class);
	}

	public void delete(Long itemId) {
		Item item = itemRepository.findById(itemId).orElseThrow(()->new ResourceNotFoundException("item", "id",itemId.toString() ));
		
		this.itemRepository.delete(item);
	}
	public ItemDTO update(Long itemId,ItemDTO itemDTO) {
		Item item = itemRepository.findById(itemId).orElseThrow(()->new ResourceNotFoundException("item", "id",itemId.toString() ));
		item.setDescription(itemDTO.getDescription());
		item.setName(itemDTO.getName());
		item.setPrice(itemDTO.getPrice());
		Item save = itemRepository.save(item);
		return this.modelMapper.map(save, ItemDTO.class);
		
	}
}