package com.mercadao.productservice.service;

import com.mercadao.productservice.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "defaulTicket")
	public Ticket findByProductId(Integer productId) {
		return restTemplate.getForObject("http://TICKET-SERVICE/ticket/product/{productId}", Ticket.class, productId);
	}

	private Ticket defaulTicket(Integer produtoId) {
		return new Ticket();
	}

}