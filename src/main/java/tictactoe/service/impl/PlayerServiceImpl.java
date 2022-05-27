package tictactoe.service.impl;

import lombok.Data;
import tictactoe.model.Field;
import tictactoe.model.Player;
import tictactoe.service.PlayerService;

@Data
public class PlayerServiceImpl implements PlayerService {

    private Player player1;
    private Player player2;
    private Integer stepOrder = 1;
    private int player1Score = 0;
    private int player2Score = 0;

    public PlayerServiceImpl(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void restartGame(Field field) {
        player1.setField(field);
        player2.setField(field);
        player1Score = 0;
        player2Score = 0;
        this.stepOrder = 1;
    }

    @Override
    public Player getCurrentPlayer() {
        Player result;
        result = stepOrder % 2 == 1 ? player1 : player2;
        return result;
    }

    public Integer getStepOrder() {
        return stepOrder;
    }

    @Override
    public void updateStepOrder() {
        ++stepOrder;
    }

    @Override
    public void incrementPlayer1Score(){
        player1Score++;
    }

    @Override
    public void incrementPlayer2Score(){
        player2Score++;
    }
}
