package com.maven.Services.impl;

import com.maven.Model.Categories;
import com.maven.Repository.CategoriesRepository;
import com.maven.Services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Categoriesimpl implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public Categories addcategories(Categories categories) {
        categories.setDate(LocalDate.now().toString());
        return categoriesRepository.save(categories);
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }
}

