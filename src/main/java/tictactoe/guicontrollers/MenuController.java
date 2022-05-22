package tictactoe.guicontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictactoe.GameApplication;
import tictactoe.core.Field;
import tictactoe.core.Player;
import tictactoe.core.impl.ComputerPlayer;
import tictactoe.core.impl.FieldImpl;
import tictactoe.core.impl.PlayerImpl;

import java.io.IOException;

public class MenuController {
    private Stage gameStage;
    private String[] args;
    @FXML
    private Button PvEmodeButton;

    @FXML
    private Button PvPmodeButton;

    @FXML
    private Button SettingsButton;

    @FXML
    void PvEmode(ActionEvent event) {
        GameApplication gameApplication = new GameApplication();
        try {
            Field field = new FieldImpl();
            Player player1 = new PlayerImpl("Player1", field, 0); // O
            Player computerPlayer = new ComputerPlayer("Computer", field, 1); // X
            gameApplication.setPlayer1(player1);
            gameApplication.setPlayer2(computerPlayer);
            gameStage = new Stage();
            gameApplication.setGameStage(gameStage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void PvPmode(ActionEvent event) {
        GameApplication gameApplication = new GameApplication();
        try {
            Field field = new FieldImpl();
            Player player1 = new PlayerImpl("Player1", field, 0); // O
            Player player2 = new PlayerImpl("Player2", field, 1); // X
            gameApplication.setPlayer1(player1);
            gameApplication.setPlayer2(player2);
            gameStage = new Stage();
            gameApplication.setGameStage(gameStage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Settings(ActionEvent event) {

    }
}
