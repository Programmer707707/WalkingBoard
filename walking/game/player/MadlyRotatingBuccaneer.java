package walking.game.player;

public class MadlyRotatingBuccaneer extends Player{
    public int playingCount=0;

    @Override
    public void turn(){
        int i=0;
        while(i<playingCount){
            i++;
        }
        playingCount++;
    }
}

//Running command:
// javac -cp "junit5all.jar;checkthat.jar" walking/game/player/Player.java walking/game/WalkingBoardTest.java walking/game/tests/DirectionStructureTest.java walking/game/tests/WalkingBoardBasicTestSuite.java walking/game/tests/WalkingBoardStructureTest.java walking/game/util/Direction.java walking/game/WalkingBoard.java walking/game/WalkingBoardWithPlayers.java walking/game/tests/WalkingBoardWithPlayersStructureTest.java walking/game/player/MadlyRotatingBuccaneer.java