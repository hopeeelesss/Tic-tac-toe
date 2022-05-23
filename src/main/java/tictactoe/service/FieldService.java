package tictactoe.service;

import tictactoe.model.Field;
import tictactoe.model.Player;

import javax.management.InstanceAlreadyExistsException;

public interface FieldService {
    void makeStep(Player player, int cellNumber) throws InstanceAlreadyExistsException;
    int checkIfGameIsOver();
    void displayFieldInConsole();
    void setField(Field field);
    Field getField();
    boolean fieldIsFull();
    void clearField();
}
