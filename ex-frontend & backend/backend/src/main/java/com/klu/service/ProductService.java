package com.klu.service;

import com.klu.model.Product;
import com.klu.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(@NonNull Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Nullable
    public Product getProductById(@NonNull Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Nullable
    public Product updateProduct(@NonNull Long id, @NonNull Product product) {
        Product existing = productRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setQuantity(product.getQuantity());
            existing.setImageUrl(product.getImageUrl());
            return productRepository.save(existing);
        }
        return null;
    }

    public void deleteProduct(@NonNull Long id) {
        productRepository.deleteById(id);
    }
}
