package com.addressbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.addressbook.model.Contact;
import com.addressbook.service.AddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService service;


    // Create AddressBook
    @PostMapping("/create/{name}")
    public String createAddressBook(@PathVariable String name) {
        return service.createAddressBook(name);
    }


    // Add Contact to AddressBook
    @PostMapping("/{bookName}/contact")
    public String addContact(@PathVariable String bookName,
                             @RequestBody Contact contact) {

        return service.addContact(bookName, contact);
    }


    // Get Contacts
    @GetMapping("/{bookName}/contacts")
    public Object getContacts(@PathVariable String bookName) {

        return service.getContacts(bookName);
    }
}
