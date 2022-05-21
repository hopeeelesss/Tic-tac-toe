package tictactoe.core;

import javax.management.InstanceAlreadyExistsException;

public interface Player {
    String getName();
    void setName(String name);
    void makeStep(int cellNumber) throws InstanceAlreadyExistsException;
    Integer getFigureInt();
    String getFigureStr();

    Boolean getAlive();
}
