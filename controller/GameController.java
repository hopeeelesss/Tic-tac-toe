package controller;

import core.Player;

public interface GameController {
    void startGame();
    void resetGame();
    void announceWinner(Player player);
    boolean gameIsOver();
}
