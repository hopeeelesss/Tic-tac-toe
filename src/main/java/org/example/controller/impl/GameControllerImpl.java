package org.example.controller.impl;

import org.example.controller.ComputerInput;
import org.example.controller.ConsoleInputUtil;
import org.example.controller.GameController;
import org.example.core.Field;
import org.example.core.Player;

public class GameControllerImpl implements GameController {
    private final Field field;
    private final Player player1;
    private final Player player2;

    private ComputerInput computerInput;
    public GameControllerImpl(Field field, Player player1, Player player2) {
        this.field = field;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void startGame() {
        field.displayFieldInConsole();
        if(!player1.getAlive())
            computerInput = new ComputerInput(player1);
        if(!player2.getAlive())
            computerInput = new ComputerInput(player2);
        while (field.getEmptyCellsList().size() != 0) {
            if(player1.getAlive()){
                ConsoleInputUtil.inputAndMakeStep(player1);
            }
            else {
                computerInput.Move();
            }
            field.displayFieldInConsole();
            if (gameIsOver()) {
                return;
            }
            if(player2.getAlive()){
                ConsoleInputUtil.inputAndMakeStep(player2);
            }
            else{
                computerInput.Move();
            }
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
