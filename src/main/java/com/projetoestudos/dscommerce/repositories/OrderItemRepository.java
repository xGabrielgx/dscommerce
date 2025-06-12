package com.projetoestudos.dscommerce.repositories;


import com.projetoestudos.dscommerce.entities.OrderItem;

import com.projetoestudos.dscommerce.entities.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

}
