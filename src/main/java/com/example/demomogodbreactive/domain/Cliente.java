package com.example.demomogodbreactive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "clientes")
@Data
@AllArgsConstructor
public class Cliente {

    @Id
    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private String sexo;
    private String telefone;
    private String email;

}
