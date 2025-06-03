package com.projetoestudos.dscommerce.controllers;

import com.projetoestudos.dscommerce.dto.OrderDTO;
import com.projetoestudos.dscommerce.dto.ProductDTO;
import com.projetoestudos.dscommerce.dto.ProductMinDTO;
import com.projetoestudos.dscommerce.services.OrderService;
import com.projetoestudos.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        OrderDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

}
