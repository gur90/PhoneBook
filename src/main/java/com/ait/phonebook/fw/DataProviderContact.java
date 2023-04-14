package com.ait.phonebook.fw;

import com.ait.phonebook.model.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "9876543999", "kan@gmail.com", "Berlin", "jam"});
        list.add(new Object[]{"Oliver1", "Kan", "9976543999", "kan3@gmail.com", "Berlin", "jam"});
        list.add(new Object[]{"Oliver2", "Kan", "9576543999 ", "kan4@gmail.com", "Berlin", "jam"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Contact.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact()
                    .setName(split[0]).setLastName(split[1]).setPhone(split[2]).setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});

            line = reader.readLine();
        }
        return list.iterator();
    }
}
