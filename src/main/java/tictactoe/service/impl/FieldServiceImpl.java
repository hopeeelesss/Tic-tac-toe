package tictactoe.service.impl;

import lombok.Getter;
import lombok.Setter;
import tictactoe.model.Field;
import tictactoe.model.Player;
import tictactoe.service.FieldService;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FieldServiceImpl implements FieldService {
    @Getter
    @Setter
    private Field field;

    public FieldServiceImpl(Field field) {
        this.field = field;
    }

    @Override
    public void makeStep(Player player, int cellNumber) throws InstanceAlreadyExistsException {
        if (!Objects.isNull(field.getFieldList().get(cellNumber))) {
            throw new InstanceAlreadyExistsException("The field is already taken");
        }
        field.getFieldList().set(cellNumber, player.getFigureInt());
    }

    /**
     @return
      * 0 - O wins
      * 1 - X wins
      * -1 - draw
      * -2 - not finished yet
      * */
    @Override
    public int checkIfGameIsOver() {
        boolean flag;
        flag = horizontalCheck(0) || verticalCheck(0) || diagonalCheck(0);
        if (flag) {
            return 0;
        }
        flag = horizontalCheck(1) || verticalCheck(1) || diagonalCheck(1);
        if (flag) {
            return 1;
        }

        if (field.getEmptyCellsList().size() == 0) {
            return -1;
        } else {
            return -2;
        }
    }

    private boolean horizontalCheck(int figure) {
        List<Integer> row = new ArrayList<>();
        int i = 0;
        while (i < 9) {
            row.clear();
            row.addAll(field.getFieldList().subList(i, i + 3));
            if (row.stream().anyMatch(Objects::isNull)) {
                i += 3;
                continue;
            }
            if ((Objects.equals(figure, row.get(0)))
                    && Objects.equals(figure, row.get(1))
                    && Objects.equals(figure, row.get(2))) {
                return true;
            }
            i += 3;
        }
        return false;
    }

    private boolean verticalCheck(int figure) {
        List<Integer> column = new ArrayList<>();
        int i = 0;
        while (i < 3) {
            column.clear();
            column.add(field.getFieldList().get(i));
            column.add(field.getFieldList().get(i + 3));
            column.add(field.getFieldList().get(i + 6));
            if (column.stream().anyMatch(Objects::isNull)) {
                i++;
                continue;
            }
            if ((Objects.equals(figure, column.get(0)))
                    && Objects.equals(figure, column.get(1))
                    && Objects.equals(figure, column.get(2))) {
                return true;
            }
            i++;
        }
        return false;
    }

    private boolean diagonalCheck(int figure) {
        List<Integer> diagonal = new ArrayList<>();
        int i = 0;
        //0 4 8
        //2 4 6
        while (i < 4) {
            diagonal.clear();
            diagonal.add(field.getFieldList().get(i));
            diagonal.add(field.getFieldList().get(4));
            diagonal.add(field.getFieldList().get(8 - i));
            if (diagonal.stream().anyMatch(Objects::isNull)) {
                i += 2;
                continue;
            }
            if ((Objects.equals(figure, diagonal.get(0)))
                    && Objects.equals(figure, diagonal.get(1))
                    && Objects.equals(figure, diagonal.get(2))) {
                return true;
            }
            i += 2;
        }
        return false;
    }

    @Override
    public void displayFieldInConsole() {
        List<Integer> fieldList = field.getFieldList();
        List<String> displayedField = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (Objects.isNull(fieldList.get(i))) {
                displayedField.add(String.valueOf(i));
            }
            if (Objects.equals(fieldList.get(i), 0)) {
                displayedField.add("O");
            }
            if (Objects.equals(fieldList.get(i), 1)) {
                displayedField.add("X");
            }
            if (i == 2 || i == 5) {
                displayedField.add("\n_________\n");
            } else if (i != 8) {
                displayedField.add(" | ");
            }
        }
        displayedField.forEach(System.out::print);
        System.out.println();
    }

    @Override
    public boolean fieldIsFull() {
        return getField().getEmptyCellsList().size() == 0;
    }

    @Override
    public void clearField() {
        getField().initializeField();
    }
}
