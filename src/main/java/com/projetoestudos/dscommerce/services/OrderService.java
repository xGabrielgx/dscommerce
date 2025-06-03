package com.projetoestudos.dscommerce.services;


import com.projetoestudos.dscommerce.dto.OrderDTO;
import com.projetoestudos.dscommerce.entities.Order;
import com.projetoestudos.dscommerce.repositories.OrderRepository;
import com.projetoestudos.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}
