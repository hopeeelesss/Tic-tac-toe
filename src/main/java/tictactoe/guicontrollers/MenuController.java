package tictactoe.guicontrollers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictactoe.GameApplication;

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
        try{
            gameStage = new Stage();
            gameApplication.setGameStage(gameStage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void PvPmode(ActionEvent event) {
        GameApplication gameApplication = new GameApplication();
        try{
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
