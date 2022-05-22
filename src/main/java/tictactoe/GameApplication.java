package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Setter;
import tictactoe.core.Player;
import tictactoe.guicontrollers.GuiGameController;

import java.io.IOException;

public class GameApplication extends Application {
    @Setter
    private Player player1;
    @Setter
    private Player player2;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Tic-tac-toe");
        stage.setScene(scene);
        stage.show();
    }

    public void setGameStage(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("game.fxml"));
        GuiGameController guiGameController = new GuiGameController();
        guiGameController.setPlayer1(player1);
        guiGameController.setPlayer2(player2);
        fxmlLoader.setController(guiGameController);
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Tic-tac-toe");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
