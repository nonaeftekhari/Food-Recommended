package com.example.foodrecommended_asd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestUnitTest extends Rest {

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSetRestName() {
		this.setRestName("Buddys");
		assertEquals(this.getRestName(), "Buddys");
		
		Exception exception = assertThrows(Exception.class, () -> this.setRestName("qsdwedwewfdfdfsdfdsvdbsvgfdsfdgfdgfdgdfsgfgsfggdsgfdgdsgfdsgdfsg"));
		assertEquals("Input must be 50 or less characters: 64", exception.getMessage());
	}

	@Test
	void testSetZipcode() {
		this.setZipcode(48201);
		assertEquals(this.getZipcode(), 48201);
		
		Exception exception = assertThrows(Exception.class, () -> this.setZipcode(123314234));
		assertEquals("Input must be 5 characters: 123314234", exception.getMessage());
		
	}
	
	
	@Test()
	void testSetWebsite() {
		Exception exception = assertThrows(Exception.class, () -> this.setWebsite("Buddys.com"));
		assertEquals("Incorrect Website", exception.getMessage());
		
		this.setWebsite("https://www.buddyspizza.com/");
		assertEquals(this.getWebsite(), "https://www.buddyspizza.com/");
	}

	@Test
	void testSetPhone() {
		this.setPhone(1234567890.0);
		assertEquals(this.getPhone(), 1234567890.0);
		
		Exception exception = assertThrows(Exception.class, () -> this.setPhone(123456789123.0));
		assertEquals("Input must be a valid phone number: 1.23456789123E11", exception.getMessage());
			
	}

	@Test
	void testSetCategory() {
		this.setCategory(0);
		assertEquals(this.getCategory(), 0);
		
		Exception exception = assertThrows(Exception.class, () -> this.setCategory(13));
		assertEquals("Input must be between 0 and 8 characters: 13", exception.getMessage());
	}

}
