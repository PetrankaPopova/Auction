package com.example.auction_demo.service;

import com.example.auction_demo.RunnableTask;
import com.example.auction_demo.ThreadPoolTaskSchedulerConfig;
import com.example.auction_demo.payload.TurnResponse;
import com.example.auction_demo.repository.*;
import com.example.auction_demo.service.contract.TurnService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TurnServiceImpl implements TurnService {


    private final TurnRepository turnRepository;

    private final ThreadPoolTaskSchedulerConfig threadPoolTaskSchedulerConfig;

    private final TurnConfigRepository turnConfigRepository;

    private final PlacedCardRepository placedCardRepository;

    private final BidRepository bidRepository;

    private final CardRepository cardRepository;

    private final PlayerRepository playerRepository;

    public TurnServiceImpl(TurnRepository turnRepository, ThreadPoolTaskSchedulerConfig threadPoolTaskSchedulerConfig, TurnConfigRepository turnConfigRepository, PlacedCardRepository placedCardRepository, BidRepository bidRepository, CardRepository cardRepository, PlayerRepository playerRepository) {
        this.turnRepository = turnRepository;
        this.threadPoolTaskSchedulerConfig = threadPoolTaskSchedulerConfig;
        this.turnConfigRepository = turnConfigRepository;
        this.placedCardRepository = placedCardRepository;
        this.bidRepository = bidRepository;
        this.cardRepository = cardRepository;
        this.playerRepository = playerRepository;
    }


    public TurnResponse findById(Long id){
         var kur = TurnResponse.mapToTurnResponse(this.turnRepository.findById(id).orElseThrow());
        return kur;
    }

    public void addNewTurn(){
       this.threadPoolTaskSchedulerConfig.threadPoolTaskScheduler().schedule(
               new RunnableTask("Specific time, 3 Seconds from now", turnRepository, turnConfigRepository, placedCardRepository, bidRepository, cardRepository, playerRepository),
               new Date(System.currentTimeMillis() + 3000)
       );
    }
}
