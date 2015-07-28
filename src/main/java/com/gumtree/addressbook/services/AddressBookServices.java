package com.gumtree.addressbook.services;

/**
 * Created by SMumbaraddi on 26/07/2015.
 */
public interface AddressBookServices {

    int getMaleCount();

    String getOldestPersonInAddressBook();

    long findOlderByDays(String p1, String p2);

}
