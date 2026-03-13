package com.addressbook.model;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }
}
