package controller.impl;

import controller.ConsoleInputUtil;
import controller.GameController;
import core.Field;
import core.Player;

import javax.management.InstanceAlreadyExistsException;
import java.util.Scanner;

public class GameControllerImpl implements GameController {
    private final Field field;
    private final Player player1;
    private final Player player2;

    public GameControllerImpl(Field field, Player player1, Player player2) {
        this.field = field;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void startGame() {
        field.displayFieldInConsole();

        while (field.getEmptyCellsList().size() != 0) {
            ConsoleInputUtil.inputAndMakeStep(player1);
            field.displayFieldInConsole();
            if (gameIsOver()) {
                return;
            }

            ConsoleInputUtil.inputAndMakeStep(player2);
            field.displayFieldInConsole();
            if (gameIsOver()) {
                return;
            }
        }
    }

    @Override
    public void resetGame() {
        //TODO: some stuff...
    }

    @Override
    public void announceWinner(Player player) {
        System.out.println("Game is over! Winner: " + player.getFigureStr() + " - " + player.getName());
    }

    @Override
    public boolean gameIsOver() {
        int winnerFlag = field.checkIfGameIsOver();
        if (winnerFlag == 0) {
            if (player1.getFigureInt().equals(0)) {
                announceWinner(player1);
            } else {
                announceWinner(player2);
            }
            return true;
        }
        if (winnerFlag == 1) {
            if (player1.getFigureInt().equals(1)) {
                announceWinner(player1);
            } else {
                announceWinner(player2);
            }
            return true;
        }
        if (winnerFlag == -1) {
            System.out.println("Game is over! It's draw!");
            return true;
        }
        return false;
    }
}
