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

    @PostMapping("/contact")
    public Contact addContact(@RequestBody Contact contact) {
        return service.addContact(contact);
    }

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return service.getAllContacts();
    }
}
