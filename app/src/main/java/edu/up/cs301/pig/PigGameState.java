package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by hall18 on 2/25/2016.
 */
public class PigGameState extends GameState{
    private int pTurn;
    private int p0Score;
    private int p1Score = 0;
    private int runningTot = 0;
    private int dieValue = 0;

    public PigGameState(){
        pTurn = 0;
        p0Score = 0;
        p1Score = 0;
        runningTot = 0;
        dieValue = 6;
    }

    public PigGameState(PigGameState oldPig){
        pTurn = oldPig.getpTurn();
        p0Score = oldPig.getP0Score();
        p1Score = oldPig.getP1Score();
        runningTot = oldPig.getRunningTot();
        dieValue = oldPig.getDieValue();
    }

    //get methodes
    public int getP0Score(){
        return p0Score;
    }

    public int getP1Score(){
        return p1Score;
    }

    public int getRunningTot(){
        return runningTot;
    }

    public int getDieValue(){
        return p0Score;
    }

    public int getpTurn(){
        return pTurn;
    }

    //set methodes
    public void setpTurn(int x){
        pTurn = x;
    }

    public void setP0Score(int x){
        p0Score = x;
    }

    public void setP1Score(int x){
        p1Score = x;
    }

    public void setRunningTot(int x){
        runningTot = x;
    }

    public void setDieValue(int x){
        dieValue = x;
    }
}


