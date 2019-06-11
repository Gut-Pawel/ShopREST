package com.example.ShopREST.assortment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssortimentRepository extends JpaRepository<Assortment , Long> {



}
