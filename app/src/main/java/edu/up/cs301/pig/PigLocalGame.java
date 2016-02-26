package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState game;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        game = new PigGameState();


        //TODO  You will implement this constructor
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if (playerIdx == game.getpTurn()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //player held
        if(action instanceof PigHoldAction){
            int player = game.getpTurn();
            //player0 rolled
            if(player == 0){
                game.setP0Score(game.getP0Score() + game.getRunningTot());
                if(players.length == 2) {
                    game.setpTurn(1);
                }

            }
            //player1 rolled
            else if(player == 1){
                game.setP1Score(game.getP1Score() + game.getRunningTot());

                if(players.length == 2) {
                    game.setpTurn(0);
                }
            }
            checkIfGameOver();
            //playerHeld
            return true;
        }
        //player Rolled
        else if (action instanceof PigRollAction){
            game.setDieValue((int) (Math.random() * 6) + 1);
            int player = game.getpTurn();
            if(game.getDieValue() == 1){
                game.setRunningTot(0);

                if(players.length == 1){
                    //do nothing else
                }
                else if(player == 0){
                    game.setpTurn(1);
                }
                else if(player == 1){
                    game.setpTurn(0);
                }
            }
            else {
                game.setRunningTot(game.getRunningTot() + game.getDieValue());
            }
            //player Rolled
            return true;
        }
        //does not recognise class
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState cpGame = new PigGameState(game);
        p.sendInfo(cpGame);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        //player 0 WINS!
        if(game.getP0Score() >= 50){
            return playerNames[0] + " WON!!! Won with: " + game.getP0Score();
        }
        //player 1 WINS!
        if(game.getP1Score() >= 50){
            return playerNames[1] + " WON!!! Won with: " + game.getP1Score();
        }
        return null;
    }

}// class PigLocalGame
