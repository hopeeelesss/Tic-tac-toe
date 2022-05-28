package tictactoe.service;

import tictactoe.model.Field;
import tictactoe.model.Player;

public interface PlayerService {
    void restartGame(Field field);
    Player getCurrentPlayer();
    void updateStepOrder();

    void incrementPlayer1Score();
    void incrementPlayer2Score();
    int getPlayer1Score();
    int getPlayer2Score();
    void setStepOrder(Integer stepOrder);

    Integer getStepOrder();
}
