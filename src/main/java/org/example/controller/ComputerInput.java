package org.example.controller;

import org.example.core.Player;
import org.example.core.impl.ComputerPlayer;

public class ComputerInput {
    private ComputerPlayer player;
    public ComputerInput(Player player){
        this.player = (ComputerPlayer) player;
    }
    public void Move(){
        player.ThinkAndMakeStep();
    }
}
