package com.example.auction_demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "turns_history")
public class TurnHistory {  //Probably Not needed class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Turn> turns;


    public Long getId() {
        return id;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }
}
