package tictactoe.service.impl;

import lombok.Getter;
import lombok.Setter;
import tictactoe.model.Field;
import tictactoe.model.Player;
import tictactoe.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {
    @Setter
    @Getter
    private Player player1;
    @Setter
    @Getter
    private Player player2;
    @Getter
    @Setter
    private Integer stepOrder = 1;

    @Getter
    private int player1Score = 0;
    @Getter
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
        if (stepOrder % 2 == 1) {
            result = player1;

        } else {
            result = player2;
        }
        return result;
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
