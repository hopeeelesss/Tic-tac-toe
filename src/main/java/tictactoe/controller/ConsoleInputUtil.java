package tictactoe.controller;

import tictactoe.core.Player;

import java.util.Scanner;

public class ConsoleInputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static void inputAndMakeStep(Player player) {
        while (true) {
            System.out.println("It's the step of player playing with " + player.getFigureStr() + " :");
            try {
                player.makeStep(scanner.nextInt());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
