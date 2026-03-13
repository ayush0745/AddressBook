package com.addressbook.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.addressbook.model.Contact;

@Service
public class AddressBookService {

    private List<Contact> contactList = new ArrayList<>();

    // Add Contact
    public Contact addContact(Contact contact) {
        contactList.add(contact);
        return contact;
    }

    // Get Contacts
    public List<Contact> getAllContacts() {
        return contactList;
    }

    // Edit Contact
    public Contact editContact(String firstName, Contact updatedContact) {

        for (Contact contact : contactList) {

            if (contact.getFirstName().equalsIgnoreCase(firstName)) {

                contact.setLastName(updatedContact.getLastName());
                contact.setAddress(updatedContact.getAddress());
                contact.setCity(updatedContact.getCity());
                contact.setState(updatedContact.getState());
                contact.setZip(updatedContact.getZip());
                contact.setPhoneNumber(updatedContact.getPhoneNumber());
                contact.setEmail(updatedContact.getEmail());

                return contact;
            }
        }
        return null;
    }

    // UC4 Delete Contact
    public String deleteContact(String firstName) {

        Iterator<Contact> iterator = contactList.iterator();

        while (iterator.hasNext()) {
            Contact contact = iterator.next();

            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                return "Contact Deleted Successfully";
            }
        }

        return "Contact Not Found";
    }
}
