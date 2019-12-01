package com.app.foodrecommendedtest;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void testEmail(){
        User test = new User();
        assertNotNull("Returning Null", User.getUserEmail());

    }

    @Test
    public void testPss(){
        User test = new User();
        assertNotNull("Returning Null", User.getPassword());
    }

    @Test
    public void testName() {
        User test = new User();
        assertNotNull("Returning Null", User.getName());
    }

    @Test
    public void testId() {
        Item test = new Item();
        assertNotNull("Returning Null", Item.getId());
    }

    @Test
    public void testItemName() {
        Item test = new Item();
        assertNotNull("Returning Null", Item.getItemName());
    }
}