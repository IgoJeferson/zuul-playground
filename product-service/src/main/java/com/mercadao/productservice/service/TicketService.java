package com.mercadao.productservice.service;

import com.mercadao.productservice.domain.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="ticket-service")
public interface TicketService {
	
	@GetMapping(value = "/ticket/product/{productId}")
	Ticket findByProductId (@PathVariable("productId") Integer productId);
		

}