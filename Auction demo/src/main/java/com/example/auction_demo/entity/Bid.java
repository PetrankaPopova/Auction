package com.example.auction_demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;

    @OneToOne
    private PlacedCard card;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlacedCard getCard() {
        return card;
    }

    public void setCard(PlacedCard card) {
        this.card = card;
    }
}
    

