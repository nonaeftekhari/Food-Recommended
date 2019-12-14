package com.example.foodrecommended_asd;

import org.junit.Test;

import static org.junit.Assert.*;

public class RestUnitTest extends Rest {


	@Test
	public void testSetRestName() {
		Rest temp = new Rest();

		temp.setRestName("Buddys");
		assertEquals(temp.getRestName(), "Buddys");
		
		//Exception exception = assertThrows(Exception.class, () -> this.setRestName("qsdwedwewfdfdfsdfdsvdbsvgfdsfdgfdgfdgdfsgfgsfggdsgfdgdsgfdsgdfsg"));
		//assertEquals("Input must be 50 or less characters: 64", exception.getMessage());
	}

	@Test
	public void testSetZipcode() {
		this.setZipcode(48201);
		assertEquals(this.getZipcode(), 48201);
		
		//Exception exception = assertThrows(Exception.class, () -> this.setZipcode(123314234));
		//assertEquals("Input must be 5 characters: 123314234", exception.getMessage());
		
	}
	
	
	@Test()
	public void testSetWebsite() {
		//Exception exception = assertThrows(Exception.class, () -> this.setWebsite("Buddys.com"));
		//assertEquals("Incorrect Website", exception.getMessage());
		
		this.setWebsite("https://www.buddyspizza.com/");
		assertEquals(this.getWebsite(), "https://www.buddyspizza.com/");
	}

	@Test
	public void testSetPhone() {
		//this.setPhone(1234567890L);
		//assertEquals(this.getPhone(), 1234567890L);
		
		//Exception exception = assertThrows(Exception.class, () -> this.setPhone(123456789123L));
		//assertEquals("Input must be a valid phone number: 1.23456789123E11", exception.getMessage());
			
	}

	@Test
	public void testSetCategory() {
		this.setCategory(0);
		assertEquals(this.getCategory(), 0);
		
		//Exception exception = assertThrows(Exception.class, () -> this.setCategory(13));
		//assertEquals("Input must be between 0 and 8 characters: 13", exception.getMessage());
	}

}
