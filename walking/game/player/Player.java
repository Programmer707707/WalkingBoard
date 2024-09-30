package walking.game.player;

import walking.game.util.Direction;

public class Player{

    private int score;
    protected Direction direction;

    public Player(){
        score = 0;
        direction = Direction.RIGHT;
    }
    public void addToScore(int new_score){
        score+=new_score;
    }
    public int getScore(){
        return score;
    }
    public Direction getDirection(){
        return direction;
    }
    public void turn(){
        if(direction == Direction.UP){
            direction = Direction.RIGHT;
        }
        else if(direction == Direction.RIGHT){
            direction = Direction.UP;
        }
        else if(direction == Direction.DOWN){
            direction = Direction.LEFT;
        }
        else if(direction == Direction.LEFT){
            direction = Direction.UP;
        }
        else{
            direction = Direction.DOWN;
        }
        
    }
}

//Commands to run player and PlayerStructure test
// javac -cp ".;checkthat.jar;junit5all.jar"  walking/game/player/Player.java walking/game/tests/PlayerStructureTest.java
// java -jar junit5all.jar execute -cp ".;checkthat.jar" -c  walking.game.tests.PlayerStructureTest