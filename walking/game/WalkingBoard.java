package walking.game;

// javac -cp "junit5all.jar;checkthat.jar" walking/game/player/Player.java walking/game/WalkingBoardTest.java walking/game/tests/DirectionStructureTest.java walking/game/tests/WalkingBoardBasicTestSuite.java walking/game/tests/WalkingBoardStructureTest.java walking/game/util/Direction.java walking/game/WalkingBoard.java


import walking.game.util.Direction;

public class WalkingBoard{

    private int[][] tiles;
    private int x, y;
    public static int BASE_TILE_SCORE = 3;
    private int SIZE_OF_TILE;
    private int position[];

    //*Updated: I tried to create jagged arrays accoriding to the documentation;
    public WalkingBoard(int size){
        SIZE_OF_TILE = size; 
        tiles = new int[size][];
        for(int i=0; i<size; i++){
            tiles[i] = new int[size];
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = BASE_TILE_SCORE;
            }
        }
    }

    
    public WalkingBoard(int[][] tiles){
        SIZE_OF_TILE = tiles.length;
        this.tiles = new int[tiles.length][];
        for(int i=0; i<tiles.length; i++){
            this.tiles[i] = new int[tiles[i].length];
            for(int j=0; j<tiles[i].length; j++){
                this.tiles[i][j] = tiles[i][j];
            }
        }
    } 

    public int[] getPosition(){
        position = new int[]{x,y};
        return position;
    }

    public int getTile(int x, int y){
        if(isValidPosition(x,y)){
            return this.tiles[x][y];
        }
        else{
            throw new IllegalArgumentException("Be careful, position is Invalid. Try with other positions");
        }
    }

    public int[][] getTiles(){
        int[][] temp = new int[tiles.length][];
        for (int i = 0; i < tiles.length; i++) {
            temp[i] = new int[tiles[i].length];
            for (int j = 0; j < tiles[i].length; j++) {
                temp[i][j] = tiles[i][j];
            }
        }
        return temp;
    }

    public boolean isValidPosition(int x, int y){
        if( x>= 0 && x < SIZE_OF_TILE && y < SIZE_OF_TILE && y>= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static int getXStep(Direction direction){
        //returns an int
        //In math for x we use left and right positions of Dekart coordinates' system, so lets use this
        int result;
        if(direction.equals(Direction.LEFT)) {
            result = -1;
        }
        else if(direction.equals(Direction.RIGHT)){
            result = 1;
        }
        else {
            result = 0;
        }
        return result;
    }

    public static int getYStep(Direction direction){
        //returns an int
        int result;
        if(direction.equals(Direction.DOWN)){
            result = -1;
        }
        else if(direction.equals(Direction.UP)){
            result = 1;
        }
        else {
            result = 0;
        }
        return result;
    }

    //This function helps me to see my tiles array
    public void printTiles() {
        for (int i = 0; i < SIZE_OF_TILE; i++) {
            for (int j = 0; j < SIZE_OF_TILE; j++) {
                System.out.print(tiles[i][j] + " ");
            }
            System.out.println();
        }
    }

    //I created this function to see x,y's current values 
    public void PrintCurrentPosition(){
        int[] arr = getPosition();
        System.out.println( arr[0] + "," + arr[1] );
    }


    //*Updated : I removed strange 0,0 position as mentioned on Canvas
    public int moveAndSet(Direction direction, int a){
        int output;
        int[] currentPosition = getPosition();// this will return [x,y]
        int newXposition = currentPosition[0] + getXStep(direction);
        int newYposition = currentPosition[1] + getYStep(direction);
        //Now I am assigning new coords to x and y. Because they shoud be changed their places
        x = newXposition;
        y = newYposition;
        if(!isValidPosition(newXposition, newYposition)){
            return 0;
        }
        else{
            output = getTile(currentPosition[0], currentPosition[1]);
            tiles[newXposition][newYposition] = a;
            return output;
        }
    }  
}
