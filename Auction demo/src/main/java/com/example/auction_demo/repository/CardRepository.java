package com.example.auction_demo.repository;

import com.example.auction_demo.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
