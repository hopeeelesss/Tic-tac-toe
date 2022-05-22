package tictactoe.guicontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import lombok.Setter;
import tictactoe.core.Field;
import tictactoe.core.Player;
import tictactoe.core.impl.ComputerPlayer;
import tictactoe.core.impl.FieldImpl;

import javax.management.InstanceAlreadyExistsException;

public class GuiGameController {
    @Setter
    private Player player1;
    @Setter
    private Player player2;
    private Integer whoseStep = 1;

    @FXML
    private Button field1;

    @FXML
    private Button field2;

    @FXML
    private Button field3;

    @FXML
    private Button field4;

    @FXML
    private Button field5;

    @FXML
    private Button field6;

    @FXML
    private Button field7;

    @FXML
    private Button field8;

    @FXML
    private Button field9;

    @FXML
    private Menu helpButton;

    @FXML
    private Menu leaveButton;

    @FXML
    private Menu offerDrawButton;

    @FXML
    private Menu restartGameButton;

    @FXML
    void fieldPressed (ActionEvent event) throws InstanceAlreadyExistsException {
        Button eventButton = (Button) event.getSource();
        Player currentPlayer = getCurrentPlayer();

        switch (eventButton.getId()) {
            case ("field1") -> makeStepAccordingToField(field1,0, currentPlayer);
            case ("field2") -> makeStepAccordingToField(field2,1, currentPlayer);
            case ("field3") -> makeStepAccordingToField(field3,2, currentPlayer);
            case ("field4") -> makeStepAccordingToField(field4,3, currentPlayer);
            case ("field5") -> makeStepAccordingToField(field5,4, currentPlayer);
            case ("field6") -> makeStepAccordingToField(field6,5, currentPlayer);
            case ("field7") -> makeStepAccordingToField(field7,6, currentPlayer);
            case ("field8") -> makeStepAccordingToField(field8,7, currentPlayer);
            case ("field9") -> makeStepAccordingToField(field9,8, currentPlayer);
        }

        if (getCurrentPlayer() instanceof ComputerPlayer && getCurrentPlayer().getField().getEmptyCellsList().size() > 0) {
            currentPlayer = getCurrentPlayer();
            ((ComputerPlayer) currentPlayer).Think();
            int cellNumber = ((ComputerPlayer) currentPlayer).getDecision();
            switch (cellNumber) {
                case (0) -> makeStepAccordingToField(field1,0, currentPlayer);
                case (1) -> makeStepAccordingToField(field2,1, currentPlayer);
                case (2) -> makeStepAccordingToField(field3,2, currentPlayer);
                case (3) -> makeStepAccordingToField(field4,3, currentPlayer);
                case (4) -> makeStepAccordingToField(field5,4, currentPlayer);
                case (5) -> makeStepAccordingToField(field6,5, currentPlayer);
                case (6) -> makeStepAccordingToField(field7,6, currentPlayer);
                case (7) -> makeStepAccordingToField(field8,7, currentPlayer);
                case (8) -> makeStepAccordingToField(field9,8, currentPlayer);
            }
        }
    }

    @FXML
    void help (ActionEvent event) {

    }

    @FXML
    void leave (ActionEvent event) {

    }

    @FXML
    void offerDraw (ActionEvent event) {

    }

    @FXML
    void restartGame (ActionEvent event) {
        Field field = new FieldImpl();
        player1.setField(field);
        player2.setField(field);
        whoseStep = 1;
        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
        field5.setText("");
        field6.setText("");
        field7.setText("");
        field8.setText("");
        field9.setText("");
    }

    private Player getCurrentPlayer() {
        Player result;
        if (whoseStep % 2 == 1) {
            result = player1;

        } else {
            result = player2;
        }
        return result;
    }

    void makeStepAccordingToField(Button field, int cellNumber, Player currentPlayer) throws InstanceAlreadyExistsException {
        currentPlayer.makeStep(cellNumber);
        field.setText(currentPlayer.getFigureStr());
        ++whoseStep;
    }
}

