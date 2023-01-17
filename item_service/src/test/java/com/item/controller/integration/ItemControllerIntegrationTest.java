package com.item.controller.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.item.payload.ItemDTO;
import com.item.util.ApplicationConstants;

@SpringBootTest
public class ItemControllerIntegrationTest {

	private RestTemplate restTemplate = new RestTemplate();

	// getItemByItemName
	@Test
	public void getItemByItemName() throws JSONException {
		ResponseEntity<String> itemByName = this.restTemplate.getForEntity(ApplicationConstants.GET_BY_ITEM_NAME_URL,
				String.class);
		String expected = ApplicationConstants.EXPECTED_ITEM;
		JSONAssert.assertEquals(expected, itemByName.getBody(), false);

	}

	// get all items
	@Test
	public void getAllItem() throws JSONException {
		ResponseEntity<String> getAllItems = this.restTemplate.getForEntity(ApplicationConstants.GET_ALL_ITEMS,
				String.class);
		String expected = ApplicationConstants.EXPECTED_ALL_ITEMS;

		assertThat(getAllItems.getBody().length()).isGreaterThan(0);

	}

	// add Item
	@Test
	@Disabled
	public void addItems() throws JSONException {
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setDescription("integratation testing");
		itemDTO.setName("Testing");
		itemDTO.setPrice(100L);
		String expected = ApplicationConstants.ADDED_ITEM_EXPEXTED;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ItemDTO> request = new HttpEntity<ItemDTO>(itemDTO, headers);
		ResponseEntity<String> savedItem = this.restTemplate.postForEntity(ApplicationConstants.ADD_ITEM_URL, request,
				String.class);
		JSONAssert.assertEquals(expected, savedItem.getBody(), false);
	}

}