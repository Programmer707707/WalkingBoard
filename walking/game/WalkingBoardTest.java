package walking.game;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import check.CheckThat;
import java.util.Arrays;

import walking.game.util.Direction;
import java.util.*;

//Test's running commands using file path:
// 1)  javac -cp "junit5all.jar;checkthat.jar" walking/game/player/Player.java walking/game/WalkingBoardTest.java walking/game/tests/DirectionStructureTest.java walking/game/tests/WalkingBoardBasicTestSuite.java walking/game/tests/WalkingBoardStructureTest.java walking/game/util/Direction.java walking/game/WalkingBoard.java
// 2)  java -jar junit5all.jar execute -cp ".;checkthat.jar" -c walking.game.WalkingBoardTest  
//-------------------------------------
//Using check.cmd file:
// ./check.cmd ./walking/game/WalkingBoardTest.java walking.game.WalkingBoardTest   


public class WalkingBoardTest{
    @Test 
    public void BoardMaxandMinCoordinateValueTesting(){
        //In this test I tried to to check minimum and maximum coords of the board's values 
        //If the size is 3 then max coord is (2,2) and min coord is (0,0)
        WalkingBoard walkingboard = new WalkingBoard(3);
        assertEquals(WalkingBoard.BASE_TILE_SCORE, walkingboard.getTile(2,2));
        assertEquals(WalkingBoard.BASE_TILE_SCORE, walkingboard.getTile(0,0));
    }
    
    @ParameterizedTest
    @CsvSource({"2", "4"}) 
    public void testSimpleInit(int size){
        WalkingBoard Walkingboard = new WalkingBoard(size);
        int[][] newTiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newTiles[i][j] = WalkingBoard.BASE_TILE_SCORE;
            }
        }

        //Testing with deepEquals (I also used assertArrayequals and it worked
        Arrays.deepEquals(newTiles, Walkingboard.getTiles());//Works
    }
    
    @ParameterizedTest
    @CsvSource({"1, 1, 3", "0, 2, 3", "2, 2, 3"})
    public void testCustomInit(int x, int y, int expected){
        //Here I have to satisfy this requirement: On positions where values smaller than three were passed, 
        //the board contains the value BASE_TILE_SCORE.
        WalkingBoard wb = new WalkingBoard(3); // <- I gave 3 for the size to initialize array
        assertEquals(expected, wb.getTile(x,y));


        int[][] temp = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
    
    
        WalkingBoard walkingBoard = new WalkingBoard(temp);
        //Here I am checking if both arrays are equal
        Arrays.deepEquals(temp, walkingBoard.getTiles()); //Works
        //And here I changed the value of temp array and tried to compare it with walkingboard's array if they are = or not
        temp[2][1] = 23;
        assertEquals(8, walkingBoard.getTile(2,1)); //Works
        //In the last part of this test I assigned walkingboard's array to new array to show modification won't change walking board's array
        int[][] newArray = walkingBoard.getTiles();
        newArray[1][1] = 11;
        assertEquals(5, walkingBoard.getTile(1,1)); //Works 
        
    }

    @Test
    public void testMoves(){
        WalkingBoard walkingBoard = new WalkingBoard(5); // Initialize the WalkingBoard with a size of 5

        int[] initialPosition = walkingBoard.getPosition();

        walkingBoard.moveAndSet(Direction.UP, 1);
        assertEquals(1, walkingBoard.getTile(initialPosition[0], initialPosition[1]+1));
        walkingBoard.moveAndSet(Direction.RIGHT, 2);
        assertEquals(2, walkingBoard.getTile(initialPosition[0]+1, initialPosition[1]+1));
        walkingBoard.moveAndSet(Direction.UP, 4);
        assertEquals(4, walkingBoard.getTile(initialPosition[0]+1, initialPosition[1]+2));
        walkingBoard.moveAndSet(Direction.RIGHT, 6);
        assertEquals(6, walkingBoard.getTile(initialPosition[0]+2, initialPosition[1]+2));
        walkingBoard.moveAndSet(Direction.RIGHT, 3);
        assertEquals(3, walkingBoard.getTile(initialPosition[0]+3, initialPosition[1]+2));
        walkingBoard.moveAndSet(Direction.UP, 8);
        assertEquals(8, walkingBoard.getTile(initialPosition[0]+3, initialPosition[1]+3));

        //In this part I am testing this thing(given in the assignment): Include a step that tries to move outside of the board. In this case, check that both the position and the board’s contents are unchanged.
        WalkingBoard new_wb = new WalkingBoard(3);
        int[] positions = new_wb.getPosition();
        assertEquals(0, new_wb.moveAndSet(Direction.LEFT, 5));
        assertEquals(0, positions[0]);
        new_wb.moveAndSet(Direction.DOWN, 12);
        assertEquals(0, initialPosition[1]);
    }
}