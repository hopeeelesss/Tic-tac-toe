package tictactoe.model;

import java.util.List;

public interface Field {
    List<Integer> getFieldList();
    List<Integer> getEmptyCellsList();
    void initializeField();
}
