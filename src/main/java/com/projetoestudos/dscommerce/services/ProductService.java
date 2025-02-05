package com.projetoestudos.dscommerce.services;

import com.projetoestudos.dscommerce.dto.ProductDTO;
import com.projetoestudos.dscommerce.entities.Product;
import com.projetoestudos.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).get();
        return new ProductDTO(product);

        /* o optional retorna um objeto product, que está dentro do optional e, usamos o get para obtermos */
        /*
        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto; */
    }
}
