package com.gumtree.addressbook.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;

/**
 * Created by SMumbaraddi on 28/07/2015.
 */
public class AddressBookServicesTests {

    private AddressBookServices addressBook;

    @Before
    public void setup(){
        addressBook = new AddressBookServicesFileRepoImpl(getTestResourcePath());
    }

    @Test
    public void testLoadAddressBook() {
        assertNotNull(addressBook);
    }

    @Test
    public void testMaleCount(){
        assertEquals(3, addressBook.getMaleCount());
    }

    @Test
    public void testOldestPersonInAddressBook(){
        assertEquals("Wes Jackson", addressBook.getOldestPersonInAddressBook());
    }

    @Test
    public void testFindOlderByDays(){
        assertEquals(2862,addressBook.findOlderByDays("Bill" , "Paul"));
    }


    public static final String getTestResourcePath(){
        URL location = AddressBookServicesTests.class.getResource("/addressbook.txt");
        String filepath  = location.getPath();
        return System.getProperty( "os.name" ).contains( "indow" ) ? filepath.substring(1) : filepath;
    }

}
