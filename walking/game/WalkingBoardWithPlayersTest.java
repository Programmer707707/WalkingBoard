package walking.game;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import check.CheckThat;
import java.util.Arrays;
import walking.game.util.Direction;
import walking.game.player.Player;
import walking.game.player.MadlyRotatingBuccaneer;
import java.util.Arrays;

public class WalkingBoardWithPlayersTest{
    @Test
    public void walk1(){
        WalkingBoardWithPlayers wbps = new WalkingBoardWithPlayers(4, 2);
        
        int[] stepCounts = {1,2,3};
        assertArrayEquals(new int[]{6,6}, wbps.walk(stepCounts));
    }

    @Test 
    public void walk2(){
        WalkingBoardWithPlayers new_wbps = new WalkingBoardWithPlayers(5, 2);
        int[] stepCounts = {5,6,7};
        assertArrayEquals(new int[]{14,13}, new_wbps.walk(stepCounts));
    }

    @Test 
    public void checkBoardState(){
        WalkingBoardWithPlayers wb = new WalkingBoardWithPlayers(5, 2);
        int[] stepsCount = {6,2,4};
        int[][] expected = {{3,3,3,3,3}, {6,3,3,3,3}, {2,3,3,3,3}, {4,6,2,4,3}, {3,3,3,3,3}};
        wb.walk(stepsCount);
        Arrays.deepEquals(expected, wb.printBoard());
    }
}


// 2 Ways of running this file:
//--------------------------------------
// Commands to run the file with using file path: 
// javac -cp "junit5all.jar;checkthat.jar" walking/game/player/Player.java walking/game/WalkingBoardTest.java walking/game/tests/DirectionStructureTest.java walking/game/tests/WalkingBoardBasicTestSuite.java walking/game/tests/WalkingBoardStructureTest.java walking/game/util/Direction.java walking/game/WalkingBoard.java walking/game/WalkingBoardWithPlayers.java walking/game/tests/WalkingBoardWithPlayersStructureTest.java walking/game/player/MadlyRotatingBuccaneer.java walking/game/WalkingBoardWithPlayersTest.java             
// java -jar junit5all.jar execute -cp ".;checkthat.jar" -c walking.game.WalkingBoardWithPlayersTest   
//--------------------------------------
// Using cmd file to run this file:
// ./check.cmd ./walking/game/WalkingBoardWithPlayersTest.java walking.game.WalkingBoardWithPlayersTest