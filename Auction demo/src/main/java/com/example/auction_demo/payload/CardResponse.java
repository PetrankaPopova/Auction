package com.example.auction_demo.payload;

import com.example.auction_demo.entity.Card;

public class CardResponse {

    private Long id;


    public static CardResponse mapCardResponse(Card card){
        var cardResponse = new CardResponse();
        cardResponse.setId(card.getId());
        return cardResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
