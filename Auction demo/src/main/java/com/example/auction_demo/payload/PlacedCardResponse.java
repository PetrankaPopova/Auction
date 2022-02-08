package com.example.auction_demo.payload;

public class PlacedCardResponse {

    private Long id;

    private PlayerResponse player;

    private CardResponse card;

    public static PlacedCardResponse mapPlacedCardResponse(CardResponse cardResponse,PlayerResponse playerResponse){
        PlacedCardResponse placedCardResponse = new PlacedCardResponse();
        placedCardResponse.setId(cardResponse.getId());
        placedCardResponse.setCard(cardResponse);
        placedCardResponse.setPlayer(playerResponse);

        return placedCardResponse;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerResponse getPlayer() {
        return player;
    }

    public void setPlayer(PlayerResponse player) {
        this.player = player;
    }

    public CardResponse getCard() {
        return card;
    }

    public void setCard(CardResponse card) {
        this.card = card;
    }

}
