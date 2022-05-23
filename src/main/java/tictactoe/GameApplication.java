package tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.controller.GuiGameController;
import tictactoe.controller.GuiMenuController;
import tictactoe.controller.impl.GuiGameControllerImpl;
import tictactoe.controller.impl.GuiMenuControllerImpl;
import tictactoe.model.Player;
import tictactoe.model.impl.ComputerPlayerImpl;
import tictactoe.model.impl.FieldImpl;
import tictactoe.model.impl.PlayerImpl;
import tictactoe.service.FieldService;
import tictactoe.service.PlayerService;
import tictactoe.service.impl.FieldServiceImpl;
import tictactoe.service.impl.PlayerServiceImpl;

import java.io.IOException;

public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("menu.fxml"));

        GuiMenuController guiMenuController = new GuiMenuControllerImpl();
        fxmlLoader.setController(guiMenuController);

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Tic-tac-toe");
        stage.setScene(scene);
        stage.show();
    }

    public void setPvPGameStage(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("game.fxml"));

        GuiGameController guiGameController = new GuiGameControllerImpl();
        FieldService fieldService = new FieldServiceImpl(new FieldImpl());
        Player player1 = new PlayerImpl("Player1", fieldService.getField(), 0); // O
        Player player2 = new PlayerImpl("Player2", fieldService.getField(), 1); // X
        PlayerService playerService = new PlayerServiceImpl(player1, player2);

        guiGameController.setPlayerService(playerService);
        guiGameController.setFieldService(fieldService);
        guiGameController.setStage(stage);
        fxmlLoader.setController(guiGameController);

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Tic-tac-toe");
        stage.setScene(scene);
        stage.show();
    }

    public void setPvEGameStage(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("game.fxml"));

        GuiGameController guiGameController = new GuiGameControllerImpl();
        FieldService fieldService = new FieldServiceImpl(new FieldImpl());
        Player player1 = new PlayerImpl("Player1", fieldService.getField(), 0); // O
        Player computerPlayer = new ComputerPlayerImpl("Computer", fieldService.getField(), 1); // X
        PlayerService playerService = new PlayerServiceImpl(player1, computerPlayer);

        guiGameController.setPlayerService(playerService);
        guiGameController.setFieldService(fieldService);
        guiGameController.setStage(stage);
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
