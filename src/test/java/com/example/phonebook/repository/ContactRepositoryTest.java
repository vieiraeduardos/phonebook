package com.example.phonebook.repository;

import com.example.phonebook.domain.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class ContactRepositoryTest {
    @Autowired
    private ContactRepository contactRepository;

    @Test
    void whenFindByPhone_thenReturnContact() {
        // Given
        Contact contact = new Contact();
        contact.setName("Conta 1");
        contact.setPhone("55000000000000");
        contactRepository.save(contact);

        //When
        Optional<Contact> found = contactRepository.findByPhone("55000000000000");

        //Then
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Conta 1");
    }

    @Test
    void whenFindNonExistentContact_whenFindByPhone_thenReturnEmpty() {
        //When
        Optional<Contact> found = contactRepository.findByPhone("55000000000000");

        //Then
        assertThat(found).isEmpty();
    }
}
