package com.aprendendodomain.domain;

import com.aprendendodomain.domain.entities.*;
import com.aprendendodomain.domain.repositories.ClientRepository;
import com.aprendendodomain.domain.repositories.OrderItemRepository;
import com.aprendendodomain.domain.repositories.OrderRepository;
import com.aprendendodomain.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Arrays;

@SpringBootApplication
public class DomainApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(DomainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Client cliente1 = new Client(null,"Alex Green", "alex@gmail.com");

		clientRepository.save(cliente1);

		Product product1 = new Product(null, "TV", 1000.0);
		Product product2 = new Product(null, "Mouse", 40.0);
		Product product3 = new Product(null, "Mouse", 40.0);
		Product product4 = new Product(null, "PC", 4100.0);

		productRepository.saveAll(Arrays.asList(product1, product2, product3));
		Order order1 = new Order(null, Instant.parse("2023-03-29T16:25:09Z"), OrderStatus.PAID,cliente1);
		Order order2 = new Order(null, Instant.parse("2023-04-30T08:21:07Z"), OrderStatus.WAITING,cliente1);

		orderRepository.saveAll(Arrays.asList(order1, order2));
		OrderItem item1 = new OrderItem(null, 1, 1000.0, product1,order1);
		OrderItem item2 = new OrderItem(null, 2, 40.0, product2,order1);
		OrderItem item3 = new OrderItem(null, 1, 4100.0, product3,order2);

		orderItemRepository.saveAll(Arrays.asList(item1, item2, item3));






	}
}
