package com.qf.service;

import com.qf.domain.AgricultureProduct;
import org.springframework.data.domain.Page;

/**
 * Created by lucifer on 2019.7.22.0022.
 */
public interface ProductService {
    Page<AgricultureProduct> findAll(int page, int size);
     AgricultureProduct save(AgricultureProduct agricultureProduct);
     AgricultureProduct update(AgricultureProduct agricultureProduct);
      int delete(Integer productId);
     AgricultureProduct loadById(Integer id);

}
