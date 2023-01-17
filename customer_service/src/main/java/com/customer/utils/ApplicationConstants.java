package com.customer.utils;

public class ApplicationConstants {

	public static String GET_BY_CUSTOMER_ID_URL="http://localhost:8999/customers/66";
	public static String EXPECTED_CUSTOMER="{\r\n"
			+ "    \"id\": 66,\r\n"
			+ "    \"email\": \"sriya@gmail.com\",\r\n"
			+ "    \"firstName\": \"sriya\",\r\n"
			+ "    \"lastName\": \"rauto\"\r\n"
			+ "}";
	public static String GET_ALL_CUSTOMERS_URL="http://localhost:8999/customers/";
	public static String EXPECTED_ALL_CUSTOMER="[\r\n"
			+ "    {\r\n"
			+ "        \"id\": 18,\r\n"
			+ "        \"email\": \"shubham@gmail.com\",\r\n"
			+ "        \"firstName\": \"shubham\",\r\n"
			+ "        \"lastName\": \"Ananda\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"id\": 66,\r\n"
			+ "        \"email\": \"sriya@gmail.com\",\r\n"
			+ "        \"firstName\": \"sriya\",\r\n"
			+ "        \"lastName\": \"rauto\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"id\": 98,\r\n"
			+ "        \"email\": \"moni@gmail.com\",\r\n"
			+ "        \"firstName\": \"moni\",\r\n"
			+ "        \"lastName\": \"Beborta\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"id\": 115,\r\n"
			+ "        \"email\": \"ram@gmail.com\",\r\n"
			+ "        \"firstName\": \"ram\",\r\n"
			+ "        \"lastName\": \"singh\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"id\": 123,\r\n"
			+ "        \"email\": \"jeet@gmail.com\",\r\n"
			+ "        \"firstName\": \"jeet\",\r\n"
			+ "        \"lastName\": \"panigrahi\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"id\": 129,\r\n"
			+ "        \"email\": \"sita@gmail.com\",\r\n"
			+ "        \"firstName\": \"sita\",\r\n"
			+ "        \"lastName\": \"kumari\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"id\": 136,\r\n"
			+ "        \"email\": \"test@gmail.com\",\r\n"
			+ "        \"firstName\": \"test\",\r\n"
			+ "        \"lastName\": \"testing\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"id\": 143,\r\n"
			+ "        \"email\": \"ramesh@birla.co\",\r\n"
			+ "        \"firstName\": \"test\",\r\n"
			+ "        \"lastName\": \"testing\"\r\n"
			+ "    }\r\n"
			+ "]";
	public static String ADD_CUSTOMER_URL="http://localhost:8999/customers/";
	public static String ADDED_CUSTOMER_EXPEXTED="{\r\n" + 
			"    \"email\": \"monolithic@gmail.com\",\r\n" + 
			"    \"firstName\": \"Babuni\",\r\n" + 
			"    \"lastName\": \"Sambit\"\r\n" + 
			"    \r\n" + 
			"}";
	
}