package org.example.launcher;

import org.example.controller.GameController;
import org.example.controller.impl.GameControllerImpl;
import org.example.core.Field;
import org.example.core.Player;
import org.example.core.impl.ComputerPlayer;
import org.example.core.impl.FieldImpl;
import org.example.core.impl.PlayerImpl;

public class Main {
    public static void main(String[] args) {
        Field field = new FieldImpl();
        Player player1 = new PlayerImpl("Player1", field, 0); // O
        Player player2 = new ComputerPlayer("Player2", field, 1); // X
        GameController gameController = new GameControllerImpl(field, player1, player2);
        gameController.startGame();
    }
}
