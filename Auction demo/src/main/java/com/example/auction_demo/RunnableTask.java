package com.example.auction_demo;

import com.example.auction_demo.entity.*;
import com.example.auction_demo.repository.*;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class RunnableTask implements Runnable{

    private String message;

    private final TurnRepository turnRepository;

    private final TurnConfigRepository turnConfigRepository;

    private final PlacedCardRepository placedCardRepository;

    private final BidRepository bidRepository;

    private final CardRepository cardRepository;

    private final PlayerRepository playerRepository;

    public RunnableTask(String message, TurnRepository turnRepository, TurnConfigRepository turnConfigRepository, PlacedCardRepository placedCardRepository, BidRepository bidRepository, CardRepository cardRepository, PlayerRepository playerRepository){
        this.message = message;
        this.turnRepository = turnRepository;
        this.turnConfigRepository = turnConfigRepository;
        this.placedCardRepository = placedCardRepository;
        this.bidRepository = bidRepository;
        this.cardRepository = cardRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public void run() {
        Turn turn = new Turn();
        TurnConfig turnConfig = this.turnConfigRepository.findById(1L).orElseThrow();
        turn.setDuration(turnConfig);
        this.turnRepository.save(turn);

        for (int i = 0; i < 5; i++) {
            long randomLong = ThreadLocalRandom.current().nextInt(1, 101);
            var card = this.cardRepository.findById(randomLong).orElseThrow();

            PlacedCard placedCard = new PlacedCard();
            placedCard.setCard(card);
            placedCard.setPlayer(this.playerRepository.findById(1L).orElseThrow());
            placedCard.setTurn(turn);

            this.placedCardRepository.save(placedCard);

            Bid bid = new Bid();
            bid.setCard(placedCard);
            bid.setPrice(1000.00);

            this.bidRepository.save(bid);
            //need to save it in placed cards
        }



        System.out.println(new Date()+" Runnable Task with "+message
                +" on thread "+Thread.currentThread().getName());
    }
}
