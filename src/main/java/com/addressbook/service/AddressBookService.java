package com.addressbook.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.addressbook.model.AddressBook;
import com.addressbook.model.Contact;

@Service
public class AddressBookService {

    // Dictionary of AddressBook name → AddressBook
    private Map<String, AddressBook> addressBookMap = new HashMap<>();


    // Create new AddressBook
    public String createAddressBook(String name) {

        if (addressBookMap.containsKey(name)) {
            return "AddressBook already exists";
        }

        addressBookMap.put(name, new AddressBook());

        return "AddressBook created successfully";
    }


    // Add contact to specific AddressBook
    //updated a duplicate contact check
    public String addContact(String bookName, Contact contact) {

        AddressBook book = addressBookMap.get(bookName);

        if (book == null) {
            return "AddressBook not found";
        }

        boolean exists = book.getContacts()
                .stream()
                .anyMatch(c -> c.equals(contact));

        if (exists) {
            return "Duplicate contact not allowed";
        }

        book.addContact(contact);

        return "Contact added successfully";
    }



    // Get contacts from AddressBook
    public Object getContacts(String bookName) {

        AddressBook book = addressBookMap.get(bookName);

        if (book == null) {
            return "AddressBook not found";
        }

        return book.getContacts();
    }
}
