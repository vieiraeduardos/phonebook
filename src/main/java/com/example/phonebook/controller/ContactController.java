package com.example.phonebook.controller;

import com.example.phonebook.domain.Contact;
import com.example.phonebook.repository.ContactRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactRepository repository;

    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Contact createContact(@Valid  @RequestBody Contact contact) {
        return this.repository.save(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable("id") Long id, @Valid @RequestBody Contact contact) {
        return this.repository.save(contact);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Contact> getContactByPhone(@PathVariable("id") Long id) {
        return this.repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContactByPhone(@PathVariable("id") Long id) {
        this.repository.deleteById(id);
    }
}