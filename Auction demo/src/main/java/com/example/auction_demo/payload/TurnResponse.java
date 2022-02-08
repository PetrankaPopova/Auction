package com.example.auction_demo.payload;

import com.example.auction_demo.entity.Turn;
import com.example.auction_demo.entity.TurnConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TurnResponse {

    private Long id;

    private TurnConfig duration;

    private Date startDate;

    private Date endDate;

    private List<BidResponse> bids;

    public TurnResponse() {
    }

    public TurnResponse(Long id, TurnConfig duration, Date startDate, Date endDate, List<BidResponse> bids) {
        this.id = id;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bids = bids;
    }

    public static TurnResponse mapToTurnResponse(Turn turn) {
        var list = turn.getBids();
        List<BidResponse> bidResponseList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            var bid = list.get(i);
            var bidResponse = BidResponse.mapToBidResponse(bid);
            bidResponseList.add(bidResponse);
        }

        return new TurnResponse(turn.getId(),
                turn.getDuration(),
                turn.getStartDate(),
                turn.getEndDate(),
                bidResponseList);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TurnConfig getDuration() {
        return duration;
    }

    public void setDuration(TurnConfig duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<BidResponse> getBids() {
        return bids;
    }

    public void setBids(List<BidResponse> bids) {
        this.bids = bids;
    }
}
