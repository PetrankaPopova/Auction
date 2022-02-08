package com.example.auction_demo.payload;

import com.example.auction_demo.entity.Player;

public class PlayerResponse {

    private Long id;

    public static PlayerResponse mapPlayerResponse(Player player){
        var playerResponse = new PlayerResponse();
        playerResponse.setId(player.getId());
        return playerResponse;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
