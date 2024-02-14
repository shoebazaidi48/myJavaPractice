package com.java.myJavaPractice.core.rpi;

import com.java.myJavaPractice.rpi.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {

    Set empty = new Set();
    Set one = new Set();
    Set many = new Set();

    @BeforeEach
    public void setUp() throws Exception {
        one.add("1");
        many.add("1");
        many.add("2");
    }

    @Test
    //(also calling the shots, get them involved")
    public void isEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(one.isEmpty());
        assertFalse(many.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(0, empty.size());
        assertEquals(1, one.size());
        assertTrue(many.size() > 1);
    }

    @Test
    public void contains() {
        assertFalse(empty.contains("1"));
        assertFalse(empty.contains("2"));
        assertTrue(one.contains("1"));
        assertFalse(one.contains("2"));
        assertTrue(many.contains("1"));
        assertTrue(many.contains("2"));
    }

    @Test
    public void remove() {
        // Create a new set
        Set set = new Set();
        // add things onto set
        set.add("1");
        set.add("2");
        set.add("3");
        // remove element from set
        set.remove("1");
        set.remove("not there");
        // check if element is not there
        assertFalse(set.contains("1"));
        // check if the size has decreased
        assertEquals(2, set.size());
    }

    @Test
    public void ignoresDuplicates() {
        // add a duplicate in a set
        Set set = new Set();
        set.add("1");
        set.add("1");
        // check the size hasn't increased
        assertEquals(1, set.size());
    }

    @Test
    public void grows() {
        // add more elements than the set can initially hold
        Set set = new Set(1);
        set.add("1");
        set.add("2");

        assertEquals(2, set.size());
    }
}
