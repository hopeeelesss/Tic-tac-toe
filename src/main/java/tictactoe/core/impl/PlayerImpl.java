package tictactoe.core.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tictactoe.core.Field;
import tictactoe.core.Player;

import javax.management.InstanceAlreadyExistsException;

@Getter
@Setter
@AllArgsConstructor
public class PlayerImpl implements Player {
    private final Field field;
    private String name;
    private final Integer figureInt;
    private final String figureStr;

    private Boolean alive;

    public PlayerImpl(String playerName, Field field, Integer figureInt) {
        this.field = field;
        this.name = playerName;
        this.figureInt = figureInt;
        alive=true;
        if (figureInt == 0) {
            figureStr = "O";
        } else {
            figureStr = "X";
        }
    }


    @Override
    public void makeStep(int cellNumber) throws InstanceAlreadyExistsException {
        field.inputFigure(cellNumber, figureInt);
    }
}
