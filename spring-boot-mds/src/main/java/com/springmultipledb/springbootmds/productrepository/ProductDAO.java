package com.springmultipledb.springbootmds.productrepository;

import com.springmultipledb.springbootmds.productentity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Integer> {
}
