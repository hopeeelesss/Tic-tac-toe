package tictactoe.launcher;

import tictactoe.controller.GameController;
import tictactoe.controller.impl.GameControllerImpl;
import tictactoe.core.Field;
import tictactoe.core.Player;
import tictactoe.core.impl.ComputerPlayer;
import tictactoe.core.impl.FieldImpl;
import tictactoe.core.impl.PlayerImpl;

public class Main {
    public static void main(String[] args) {
        Field field = new FieldImpl();
        Player player1 = new PlayerImpl("Player1", field, 0); // O
        Player player2 = new ComputerPlayer("Player2", field, 1); // X
        GameController gameController = new GameControllerImpl(field, player1, player2);
        gameController.startGame();
    }
}
