package com.example.auction_demo.payload;

import com.example.auction_demo.entity.Bid;
import com.example.auction_demo.entity.Card;
import com.example.auction_demo.entity.PlacedCard;
import com.example.auction_demo.entity.Player;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class BidResponse {

    private Long id;

    private double price;

    private PlacedCardResponse card; //placed card response

    public BidResponse(){}

    public BidResponse(Long id, double price, PlacedCardResponse card) {
        this.id = id;
        this.price = price;
        this.card = card;
    }

//    private static CardResponse mapCardResponse(Card card){
//        var cardResponse = new CardResponse();
//        cardResponse.setId(card.getId());
//        return cardResponse;
//    }

//    private static PlayerResponse mapPlayerResponse(Player player){
//        var playerResponse = new PlayerResponse();
//        playerResponse.setId(player.getId());
//        return playerResponse;
//    }

//    private static PlacedCardResponse mapPlacedCardResponse(CardResponse cardResponse,PlayerResponse playerResponse){
//        PlacedCardResponse placedCardResponse = new PlacedCardResponse();
//        placedCardResponse.setId(cardResponse.getId());
//        placedCardResponse.setCard(cardResponse);
//        placedCardResponse.setPlayer(playerResponse);
//
//        return placedCardResponse;
//    }

    public static BidResponse mapToBidResponse(Bid bid){
        var cardResponse = CardResponse.mapCardResponse(bid.getCard().getCard());
        var playerResponse = PlayerResponse.mapPlayerResponse(bid.getCard().getPlayer());
        var placedCardResponse = PlacedCardResponse.mapPlacedCardResponse(cardResponse,playerResponse);

        return new BidResponse(bid.getId(),
                bid.getPrice(),
                placedCardResponse);
    }

    //        var card = placedCard.getCard();
//        var cardResponse = new CardResponse();
//        cardResponse.setId(card.getId());

    //        var player = placedCard.getPlayer();
//        var playerResponse = new PlayerResponse();
//        playerResponse.setId(player.getId());

    // var turn = placedCard.getTurn();
    // var turnResponse = TurnResponse.mapToTurnResponse(turn); //bezkraen cikul

    //        placedCardResponse.setId(placedCardId);
//        placedCardResponse.setCard(cardResponse);
//        placedCardResponse.setPlayer(playerResponse);
    //v CardResponsa pazim playera i kartata
    //placedCardResponse.setTurn(turnResponse);

//        var placedCard = bid.getCard();
//        var placedCardId = placedCard.getId();

    //        PlacedCardResponse placedCardResponse = new PlacedCardResponse();
//        placedCardResponse.setId(cardResponse.getId());
//        placedCardResponse.setCard(cardResponse);
//        placedCardResponse.setPlayer(playerResponse);



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PlacedCardResponse getCard() {
        return card;
    }

    public void setCard(PlacedCardResponse card) {
        this.card = card;
    }
}
