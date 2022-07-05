package com.hkb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hkb.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("")
	public List<Product> findAllByCategory_Id(int id);
}
