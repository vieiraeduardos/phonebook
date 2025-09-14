package com.example.phonebook.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome é obrigatório.")
    private String name;
    @NotBlank(message = "O telefone é obrigatório.")
    @Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres.")
    private String phone;
    @Email(message = "O formato do e-mail é inválido.")
    private String email;

}