package com.projetoestudos.dscommerce.services;

import com.projetoestudos.dscommerce.dto.ProductDTO;
import com.projetoestudos.dscommerce.entities.Product;
import com.projetoestudos.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {

        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);

        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO updtade(Long id, ProductDTO dto) {

        Product entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);

        return new ProductDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }

}
