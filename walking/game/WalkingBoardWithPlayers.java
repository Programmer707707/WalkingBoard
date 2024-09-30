package walking.game;
import walking.game.player.Player;
import walking.game.player.MadlyRotatingBuccaneer;

//*Update : i removed my move() helper function that i used inside walk() function. And i combined two of with two nested loops

public class WalkingBoardWithPlayers extends WalkingBoard{
    private Player[] players;
    private int round;
    public static final int SCORE_EACH_STEP = 13;
    public WalkingBoardWithPlayers(int[][] board, int playerCount){
        super(board.length);
        initPlayers(playerCount);
        round = 0;
    }
    public WalkingBoardWithPlayers(int size, int playerCount){
        super(size);
        initPlayers(playerCount);
        round = 0;
    }
    private void initPlayers(int playerCount){
        if(playerCount < 2){
            throw new IllegalArgumentException("Invalid, players are less then 2");
        }
        else{
            players = new Player[playerCount];
            players[0] = new MadlyRotatingBuccaneer();

            for(int i=1; i<playerCount; i++){
                players[i] = new Player();
            }
        }
    }

    public int[] walk(int... stepCounts){
        int[] scores = new int[players.length];
        int player_index = 0;

        for(int i=0; i<players.length; i++){
            Player player = players[player_index];
            player.turn();

            int total_step = 0;
            for(int j=0; j<stepCounts.length; j++){
                int need_steps = Math.min(stepCounts[j], SCORE_EACH_STEP - total_step);
                if(need_steps > 0 && total_step < SCORE_EACH_STEP ){
                    player.addToScore(moveAndSet(player.getDirection(), need_steps));
                    total_step = total_step + need_steps;
                }
            }
            scores[player_index] = player.getScore(); player_index +=1;  
            round++;
        }
        return scores;
    }    
    
    //I used this function to check board's state after the game as mentioned in the comments section canvas
    public int[][] printBoard() {
        return getTiles();
    }
}
  

//Running commands
//javac -cp "junit5all.jar;checkthat.jar" walking/game/player/Player.java walking/game/WalkingBoardTest.java walking/game/tests/DirectionStructureTest.java walking/game/tests/WalkingBoardBasicTestSuite.java walking/game/tests/WalkingBoardStructureTest.java walking/game/util/Direction.java walking/game/WalkingBoard.java walking/game/WalkingBoardWithPlayers.java walking/game/tests/WalkingBoardWithPlayersStructureTest.java walking/game/player/MadlyRotatingBuccaneer.java
//java -jar junit5all.jar execute -cp ".;checkthat.jar" -c walking.game.tests.WalkingBoardWithPlayersStructureTest                                     