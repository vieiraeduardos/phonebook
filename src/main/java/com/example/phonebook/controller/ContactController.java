package com.example.phonebook.controller;

import com.example.phonebook.domain.Contact;
import com.example.phonebook.exception.ContatoNaoEncontradoException;
import com.example.phonebook.repository.ContactRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
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
    public ResponseEntity<Page<Contact>> getAllContacts(Pageable pageable) {
        Page<Contact> contactsPage = repository.findAll(pageable);
        return ResponseEntity.ok(contactsPage);
    }

    @GetMapping("/{id}")
    public Contact getContactByPhone(@PathVariable("id") Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ContatoNaoEncontradoException("Contato não encontrado com o ID " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactByPhone(@PathVariable("id") Long id) {
        if(!repository.existsById(id)) {
            throw new ContatoNaoEncontradoException("Contato não encontrado com o ID " + id);
        }

        this.repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}