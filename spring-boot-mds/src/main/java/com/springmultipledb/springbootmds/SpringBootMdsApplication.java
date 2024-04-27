package com.springmultipledb.springbootmds;

import com.springmultipledb.springbootmds.orderentity.Order;
import com.springmultipledb.springbootmds.orderrepository.OrderDAO;
import com.springmultipledb.springbootmds.productentity.Product;
import com.springmultipledb.springbootmds.productrepository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringBootMdsApplication implements CommandLineRunner {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private OrderDAO orderDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMdsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("....Starting inserting the data....");
		Product product = new Product(1, "Mobile", 20000);
        productDAO.save(product);

		Order order = new Order(101,"Anish", LocalDate.now());
		orderDAO.save(order);
		System.out.println(".... insertion completed....");

	}
}
