package com.item.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.item.payload.ItemDTO;
import com.item.service.ItemService;
import com.item.util.ApiResponse;

@RequestMapping("/items")
@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/")
	public List<ItemDTO> all() {
		return itemService.all();
	}

	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{itemName}")
	public ItemDTO get(@PathVariable String itemName) {
		return itemService.get(itemName);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public ItemDTO put(@PathVariable Long id,@Valid @RequestBody ItemDTO itemDTO) {
		
		return this.itemService.update(id, itemDTO);
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/{id}")
	public ApiResponse delete(@PathVariable long id) {
		itemService.delete(id);
		ApiResponse apiResponse=new ApiResponse("item deleted successfully", true);
		return apiResponse;
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ItemDTO add(@Valid @RequestBody ItemDTO itemDTO) {
		return itemService.save(itemDTO);
	}

	

}