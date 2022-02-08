package com.example.auction_demo.controller;

import com.example.auction_demo.payload.TurnResponse;
import com.example.auction_demo.service.contract.TurnService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurnController {

    private final TurnService turnService;

    public TurnController(TurnService turnService) {
        this.turnService = turnService;
    }

    @GetMapping("/turn/{turnId}")
    public TurnResponse findById(@PathVariable Long turnId){
         var kur = this.turnService.findById(turnId);
         return kur;
    }

    @GetMapping("/test")
    public void test(){
         this.turnService.addNewTurn();
    }
}
