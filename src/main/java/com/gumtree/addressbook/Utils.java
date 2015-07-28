package com.gumtree.addressbook;

import com.gumtree.addressbook.model.Address;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * Created by SMumbaraddi on 28/07/2015.
 */
public class Utils {

    public static Address getAddressObjectFromFlatVersion(String flatAddress) {
        Address address = null;
        if (flatAddress != null && !"".equals(flatAddress)) {
            String[] values = flatAddress.split(",");
            DateTimeFormatter dateTimeFormatter =
                    new DateTimeFormatterBuilder().appendPattern("dd/MM/")
                            .appendValueReduced(
                                    ChronoField.YEAR, 2, 2, Year.now().getValue() - 80
                            ).toFormatter();
            address = new Address(values[0].trim(), values[1].trim(), LocalDate.parse(values[2].trim(), dateTimeFormatter));
        }
        return address;
    }
}
