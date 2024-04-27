package com.springmultipledb.springbootmds.orderrepository;

import com.springmultipledb.springbootmds.orderentity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDAO extends CrudRepository<Order, Integer> {

}
