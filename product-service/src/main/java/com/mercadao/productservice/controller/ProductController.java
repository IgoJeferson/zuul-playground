package com.mercadao.productservice.controller;

import com.mercadao.productservice.domain.Product;
import com.mercadao.productservice.repository.ProductRepository;
import com.mercadao.productservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private TicketService ticketService;

	@GetMapping(value = "/product")
	public Iterable<Product> all (){
		return productRepository.findAll();
	}
	
	@GetMapping(value = "/product/{productId}")
	public Product findByAccountId (@PathVariable Integer productId){

		Product product = productRepository.findByProductId(productId);
		
		product.setTicket(ticketService.findByProductId(productId));
		
		return product;
	}
	
}