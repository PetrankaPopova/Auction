package com.example.auction_demo.service.contract;

import com.example.auction_demo.payload.TurnResponse;

public interface TurnService {
    TurnResponse findById(Long id);

    void addNewTurn();
}
