package com.veggy.backend.veggy_backend.repository;

import com.veggy.backend.veggy_backend.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}