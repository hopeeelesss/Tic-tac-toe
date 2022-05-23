package tictactoe.controller.impl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictactoe.GameApplication;
import tictactoe.controller.GuiMenuController;

import java.io.IOException;

public class GuiMenuControllerImpl implements GuiMenuController {
    private Stage gameStage;
    private String[] args;
    @FXML
    private Button PvEmodeButton;
    @FXML
    private Button PvPmodeButton;
    @FXML
    private Button SettingsButton;

    @Override
    @FXML
    public void PvEmode(ActionEvent event) {
        GameApplication gameApplication = new GameApplication();
        try {
            gameStage = new Stage();
            gameApplication.setPvEGameStage(gameStage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @FXML
    public void PvPmode(ActionEvent event) {
        GameApplication gameApplication = new GameApplication();
        try {
            gameStage = new Stage();
            gameApplication.setPvPGameStage(gameStage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @FXML
    public void Settings(ActionEvent event) {

    }
}
