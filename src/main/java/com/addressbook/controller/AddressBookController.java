package com.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.addressbook.model.Contact;
import com.addressbook.service.AddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    // Add Contact
    @PostMapping("/contact")
    public Contact addContact(@RequestBody Contact contact) {
        return service.addContact(contact);
    }

    // Get Contacts
    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return service.getAllContacts();
    }

    // Edit Contact
    @PutMapping("/edit/{firstName}")
    public Contact editContact(@PathVariable String firstName,
                               @RequestBody Contact contact) {

        return service.editContact(firstName, contact);
    }

    // UC4 Delete Contact
    @DeleteMapping("/delete/{firstName}")
    public String deleteContact(@PathVariable String firstName) {

        return service.deleteContact(firstName);
    }
}
