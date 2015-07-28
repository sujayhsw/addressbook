package com.gumtree.addressbook;

import com.gumtree.addressbook.services.AddressBookServices;
import com.gumtree.addressbook.services.AddressBookServicesFileRepoImpl;

import static com.gumtree.addressbook.Utils.*;

/**
 * Created by SMumbaraddi on 28/07/2015.
 */
public class AddressBookApp {

    private static final String FILE_SEPARATOR = System.getProperty("file.separator");

    public static void main(String[] args) {

        String inputFilePath = null;

        assert args.length < 2
                : "Application Expects 0 or 1 input, in case of 1 you can provide different addressbook file path";

        if(args.length == 1 ){
            System.out.println("using provided file path to load address");
            inputFilePath = args[0];
        }else {
            System.out.println("loading default sample addreesbook file");
            inputFilePath = "data"+ FILE_SEPARATOR + "addressbook.txt";
        }


        AddressBookServices addressBookServices = new AddressBookServicesFileRepoImpl(inputFilePath);

        System.out.format(" Male count in provided address book is %d %n", addressBookServices.getMaleCount());
        System.out.format(" Oldest person in the Address is %s %n", addressBookServices.getOldestPersonInAddressBook());
        System.out.format(" Age difference between Bill & Paul in days is %d %n", addressBookServices.findOlderByDays("Bill", "Paul"));
    }
}
