package tictactoe.model.impl;

import lombok.Getter;
import tictactoe.model.Field;

import java.util.ArrayList;
import java.util.List;
@Getter
public class FieldImpl implements Field {
    /**
     * @value
     *  * Integer figures equivalent
     *  * 0 - O
     *  * 1 - X
     *  * null - empty cell
     *  Field is hold as arraylist. Field cells interpretation as GUI
     *  * 0 1 2
     *  * 3 4 5
     *  * 6 7 8
     */
    @Getter
    private List<Integer> fieldList;

    public FieldImpl() {
        initializeField();
    }

    @Override
    public void initializeField() {
        this.fieldList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fieldList.add(null);
        }
    }

    @Override
    public List<Integer> getEmptyCellsList() {
        List<Integer> emptyCellsList = new ArrayList<>();
        for(int i=0;i<9;++i){
            if(getFieldList().get(i) == null){
                emptyCellsList.add(i);
            }
        }
        return emptyCellsList;
    }
}
