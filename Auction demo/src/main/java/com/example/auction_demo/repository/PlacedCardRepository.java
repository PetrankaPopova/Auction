package com.example.auction_demo.repository;

import com.example.auction_demo.entity.PlacedCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacedCardRepository extends JpaRepository<PlacedCard,Long> {
}
