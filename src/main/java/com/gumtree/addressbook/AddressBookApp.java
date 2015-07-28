package com.gumtree.addressbook;

import com.gumtree.addressbook.services.AddressBookServices;
import com.gumtree.addressbook.services.AddressBookServicesFileRepoImpl;

/**
 * Created by SMumbaraddi on 28/07/2015.
 */
public class AddressBookApp {
    public static void main(String[] args) {
        assert args.length == 1
                : "Application Expects input addressbook file path as argument";

        AddressBookServices addressBookServices = new AddressBookServicesFileRepoImpl(args[0]);

        System.out.format(" Male count in provided address book is %d %n", addressBookServices.getMaleCount());
        System.out.format(" Oldest person is %s %n", addressBookServices.getOldestPersonInAddressBook());
        System.out.format(" Age difference between Bill & Paul in days is %d %n", addressBookServices.findOlderByDays("Bill", "Paul"));
    }
}
