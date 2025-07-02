package com.example.demomogodbreactive.repository;

import com.example.demomogodbreactive.domain.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;


public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {


}
