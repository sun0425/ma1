package com.qf.dao;

import com.qf.domain.AgricultureProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lucifer on 2019.7.22.0022.
 */
public interface ProductRepository extends JpaRepository<AgricultureProduct, Integer> {

}
