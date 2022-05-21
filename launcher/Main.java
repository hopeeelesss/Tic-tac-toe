package launcher;

import controller.GameController;
import controller.impl.GameControllerImpl;
import core.Field;
import core.Player;
import core.impl.FieldImpl;
import core.impl.PlayerImpl;

public class Main {
    public static void main(String[] args) {
        Field field = new FieldImpl();
        Player player1 = new PlayerImpl("Player1", field, 0); // O
        Player player2 = new PlayerImpl("Player2", field, 1); // X
        GameController gameController = new GameControllerImpl(field, player1, player2);
        gameController.startGame();
    }
}
