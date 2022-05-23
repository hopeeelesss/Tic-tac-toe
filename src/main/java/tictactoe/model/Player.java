package tictactoe.model;

public interface Player {
    String getName();
    void setName(String name);
    Integer getFigureInt();
    String getFigureStr();
    Field getField();
    void setField(Field field);
}
