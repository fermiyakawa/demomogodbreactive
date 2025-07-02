package com.example.demomogodbreactive.service;

import com.example.demomogodbreactive.domain.Cliente;
import com.example.demomogodbreactive.repository.ClienteRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ClienteService {


    private static final Logger log = LogManager.getLogger(ClienteService.class);

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Flux<Cliente> listarTodos(){
        return repository.findAll().doOnNext(cliente -> log.info("Listando: {}", cliente.getNome()));
    }

    public Mono<Cliente> buscaPorId(String id){
        return repository.findById(id).doOnNext(cliente -> log.info("Buscando ID: " + cliente.getId()));
    }

    public Mono<Cliente> insert(Cliente cliente){
        return repository.insert(cliente).doOnNext(chave -> log.info("Inserindo: " + chave));
    }

    public Mono<Cliente> update(Cliente cliente){
        return repository.save(cliente).doOnNext(chave -> log.info("Atualizando: " + chave));
    }

    public Mono<Void> delete(String id){
         return repository.findById(id)
                .flatMap(cliente -> repository.delete(cliente)
                        .doOnNext(chave -> log.info("Excluindo: " + chave)));


    }


}
