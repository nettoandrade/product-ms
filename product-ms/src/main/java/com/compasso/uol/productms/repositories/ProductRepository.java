package com.compasso.uol.productms.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.compasso.uol.productms.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("FROM Product AS prod WHERE prod.price between ?0 and ?1 and (prod.name like '%'+ ?2 +'%' or prod.description like '%'+ ?2 +'%')")
	List<Product> findByMinPriceAndMaxPriceAndNameOrDescription(BigDecimal minPrice, BigDecimal maxPrice, String q);
}
