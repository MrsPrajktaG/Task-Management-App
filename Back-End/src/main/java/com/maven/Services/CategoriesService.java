package com.maven.Services;

import com.maven.Model.Categories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriesService {

    Categories addcategories(Categories categories);

    List<Categories> getAllCategories();
}
