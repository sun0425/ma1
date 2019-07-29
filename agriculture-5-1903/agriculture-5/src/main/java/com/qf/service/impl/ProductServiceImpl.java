package com.qf.service.impl;

import com.qf.dao.ProductRepository;
import com.qf.domain.AgricultureProduct;
import com.qf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * Created by lucifer on 2019.7.22.0022.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<AgricultureProduct> findAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<AgricultureProduct> all = productRepository.findAll(pageable);
        return all;
    }

    @Override
    public AgricultureProduct save(AgricultureProduct agricultureProduct) {
        AgricultureProduct save = productRepository.save(agricultureProduct);
        return save;
    }

    @Override
    public int delete(Integer productId) {
        productRepository.deleteById(productId);
        boolean b = productRepository.existsById(productId);
        return b ? 0 : 1;
    }

    @Override
    public AgricultureProduct update(AgricultureProduct agricultureProduct) {
        AgricultureProduct product = productRepository.saveAndFlush(agricultureProduct);
        return product;
    }

    @Override
    public AgricultureProduct loadById(Integer id) {
        Optional<AgricultureProduct> byId = productRepository.findById(id);
        AgricultureProduct agricultureProduct = null;
        if (byId.isPresent()) {
            agricultureProduct = byId.get();
        }
        return agricultureProduct;
    }
  /*  public int delete1(AgricultureProduct agricultureProduct) {
        productRepository.deleteAllInBatch();
        boolean b = productRepository.existsById(agricultureProduct.getProductId());
        return b ? 0 : 1;
    }*/


}
