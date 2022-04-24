package core.impl;

import core.Field;
import core.Player;

import javax.management.InstanceAlreadyExistsException;

public class PlayerImpl implements Player {
    private final Field field;
    private String name;
    private final Integer figureInt;
    private final String figureStr;

    public PlayerImpl(String playerName, Field field, Integer figureInt) {
        this.field = field;
        this.name = playerName;
        this.figureInt = figureInt;
        if (figureInt == 0) {
            figureStr = "O";
        } else {
            figureStr = "X";
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getFigureInt() {
        return figureInt;
    }

    @Override
    public String getFigureStr() {
        return figureStr;
    }

    @Override
    public void makeStep(int cellNumber) throws InstanceAlreadyExistsException {
        field.inputFigure(cellNumber, figureInt);
    }
}
