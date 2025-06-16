package com.projetoestudos.dscommerce.services;

import com.projetoestudos.dscommerce.dto.CategoryDTO;
import com.projetoestudos.dscommerce.dto.ProductMinDTO;
import com.projetoestudos.dscommerce.entities.Category;
import com.projetoestudos.dscommerce.entities.Product;
import com.projetoestudos.dscommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).toList();
    }
}
