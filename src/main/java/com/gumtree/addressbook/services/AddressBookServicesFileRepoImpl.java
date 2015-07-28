package com.gumtree.addressbook.services;

import com.gumtree.addressbook.Utils;
import com.gumtree.addressbook.model.Address;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by SMumbaraddi on 28/07/2015.
 */
public class AddressBookServicesFileRepoImpl implements AddressBookServices {

    private Set<Address> addresses;

    public AddressBookServicesFileRepoImpl(String filePath) {
        load(filePath);
    }

    private void load(String filepath) {
        try {
            addresses = Files.lines(Paths.get(filepath))
                    .map(line -> Utils.getAddressObjectFromFlatVersion(line))
                    .collect(Collectors.toSet());
        }catch(IOException ioe){
            throw new RuntimeException("File Reading failed with " + ioe.getMessage() , ioe);
        }

    }


    @Override
    public int getMaleCount() {
        return (int)addresses.stream()
                                .filter(a -> "Male".equals(a.getGender()))
                                .count();
    }

    @Override
    public String getOldestPersonInAddressBook() {
        return addresses.stream().sorted((p1,p2) -> p1.getDob().compareTo(p2.getDob())).findFirst().get().getName();
    }

    @Override
    public long findOlderByDays(String p1, String p2) {
        List<Address> filteredAddress =
                addresses.stream()
                        .filter(p -> p.getName().toLowerCase().startsWith(p1.toLowerCase()) || p.getName().toLowerCase().startsWith(p2.toLowerCase()))
                        .sorted((a1, a2) -> a1.getDob().compareTo(a2.getDob()))
                        .collect(Collectors.toList());
        if(filteredAddress.size() !=2 ) throw new RuntimeException("Invalid Input , may be multiple persons with same name or no person for given name");
        return ChronoUnit.DAYS.between(filteredAddress.get(0).getDob(), filteredAddress.get(1).getDob());
    }


}
