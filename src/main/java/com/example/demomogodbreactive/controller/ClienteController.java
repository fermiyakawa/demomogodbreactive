package com.example.demomogodbreactive.controller;

import com.example.demomogodbreactive.domain.Cliente;
import com.example.demomogodbreactive.service.ClienteService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public Flux<Cliente> findAll(){
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Mono<Cliente> findById(@PathVariable String id){
        return clienteService.buscaPorId(id);
    }

    @PostMapping()
    public Mono<Cliente> insert(@RequestBody Cliente cliente){
        return clienteService.insert(cliente);
    }

    @PutMapping("/{id}")
    public Mono<Cliente> update(@PathVariable String id, @RequestBody Cliente cliente){
        cliente.setId(id);
        return clienteService.update(cliente);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return clienteService.delete(id);
    }

}
