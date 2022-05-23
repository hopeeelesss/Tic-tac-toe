package tictactoe.model.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tictactoe.model.Field;
import tictactoe.model.Player;

@Getter
@Setter
@AllArgsConstructor
public class PlayerImpl implements Player {
    @Getter
    @Setter
    private Field field;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Integer figureInt;

    @Getter
    @Setter
    private String figureStr;

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
}
