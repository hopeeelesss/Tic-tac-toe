package org.example.core.impl;

import lombok.Getter;
import lombok.Setter;
import org.example.core.Field;
import org.example.core.Player;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class ComputerPlayer implements Player {
    private final Field field;
    private String name;
    private final Integer figureInt;
    private final String figureStr;
    private Boolean alive;

    private ArrayList<HashSet<Integer>> sets = new ArrayList<>();

    public ComputerPlayer(String playerName, Field field, Integer figureInt) {
        this.name=playerName;
        this.field=field;
        this.figureInt=figureInt;
        if(figureInt==0){
            this.figureStr="0";
        }else
            this.figureStr="X";
        this.setAlive(false);

        InitializeSets();
        System.out.println(sets);
    }

    private void InitializeSets(){
        for(int i=0;i<8;++i){
            sets.add(i,new HashSet<>());
        }
        for(int i=0;i<9;++i){
            sets.get(i/3).add(i);
            sets.get(i%3+3).add(i);
            if(i%4==0)
                sets.get(6).add(i);
            if(i%2==0&&(i)*(i-8)<0)
                sets.get(7).add(i);
        }

    }

    public void ThinkAndMakeStep(){
        int decision=0;
        List<Integer> emptyCells = field.getEmptyCellsList();
        List<Integer> analyzeResults = new ArrayList<>();
        for (HashSet<Integer> set: sets
             ) {
            analyzeResults.add(ScanElem(set,field.getFieldList()));
        }
        System.out.println(analyzeResults);
        decision = GetIndexToMove(new HashSet<>(emptyCells),emptyCells);
        for(int i=0;i<sets.size();++i) {
            if (analyzeResults.get(i) == 2) {
                decision = GetIndexToMove(sets.get(i), emptyCells);
            }
        }
        for(int i=0;i<sets.size();++i) {
            if (analyzeResults.get(i) == -2) {
                decision = GetIndexToMove(sets.get(i), emptyCells);
            }
        }


        try {
            field.inputFigure(decision, figureInt);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private int GetIndexToMove(HashSet<Integer> set, List<Integer> emptyCells){
        for (Integer cell: set
             ) {
            if (emptyCells.contains(cell))
                return cell;
        }
        return 0;
    }

    private Integer ScanElem(HashSet<Integer> set, List<Integer> cells){
        Integer result=0;
        Integer enemyFigure = 1-this.figureInt;
        for (Integer elem: set
             ) {
            if(Objects.equals(cells.get(elem), enemyFigure)){
                --result;
                continue;
            }
            if(Objects.equals(cells.get(elem), figureInt)) {
                ++result;
            }
        }
        return result;
    }

    private Integer StepToWin(){
        return null;
    }

    private Integer StepToSurvive(){
        return null;
    }

    private Integer RandomStep(){
        return null;
    }

    @Override
    public void makeStep(int cellNumber) throws InstanceAlreadyExistsException {
        field.inputFigure(cellNumber,figureInt);
    }
}
