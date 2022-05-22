package tictactoe.controller;

import tictactoe.core.Player;
import tictactoe.core.impl.ComputerPlayer;

public class ComputerInput {
    private final ComputerPlayer player;
    public ComputerInput(Player player){
        this.player = (ComputerPlayer) player;
    }
    public void Move(){
        player.Think();
    }
}
