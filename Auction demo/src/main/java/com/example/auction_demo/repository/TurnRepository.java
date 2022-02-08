package com.example.auction_demo.repository;

import com.example.auction_demo.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnRepository extends JpaRepository<Turn,Long> {
}
