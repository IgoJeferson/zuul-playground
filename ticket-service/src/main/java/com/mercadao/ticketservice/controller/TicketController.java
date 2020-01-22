package com.mercadao.ticketservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mercadao.ticketservice.domain.Ticket;
import com.mercadao.ticketservice.repository.TicketRepository;

@RestController()
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping
    public Iterable<Ticket> all() {
        return ticketRepository.findAll();
    }

    @GetMapping("/{numeroPremiado}/")
    public Ticket findTicketByNumeroPremiado(@PathVariable Integer numeroPremiado) {
        return ticketRepository.findTicketByNumeroPremiado(numeroPremiado);
    }

    @GetMapping("/product/{productId}")
    public Ticket findAllByProductId(@PathVariable Integer productId) {
        return ticketRepository.findAllByProductId(productId);
    }
}