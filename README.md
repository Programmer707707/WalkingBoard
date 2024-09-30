## WalkingBoard Java Project
## Project Overview
The WalkingBoard class represents a board with a figure standing on a position (x, y). Each position on the board has an associated value. The board can be initialized in two ways: with a fixed size or with given dimensions and initial values, including the ability for non-uniform rows.

## Features Implemented
## 1. Initialization
The board can be initialized as a square or with custom dimensions and initial values.
If custom values are smaller than BASE_TILE_SCORE, they are set to BASE_TILE_SCORE.
The board's structure is safely copied to prevent external access to internal data.
## 2. Operations
getPosition(): Returns the current coordinates (x, y).
getTile(x, y): Returns the value of the specified board position. If the position is invalid, throws an IllegalArgumentException.
getTiles(): Returns all values of the board, creating a deep copy to protect internal data.
moveAndSet(newX, newY, newValue): Moves the piece to a new position and sets its value. Cancels the move if it would leave the board, returning 0.
setAndMove(newValue, newX, newY): Similar to moveAndSet, but sets the current position value before moving.
## 3. Extended Functionality
Added players with unique behaviors. One player type (MadlyRotatingBuccaneer) has dynamic movement, changing direction based on how many times they have played.
The players take turns in a loop, following specific movement rules and scoring accordingly.
Player score is updated with each move based on board values.
## Testing
The project includes extensive JUnit 5 tests to ensure functionality, including:

## Structural Tests: Validate the correct implementation of the board and player classes.
## Movement Tests: Verify the correctness of multiple moves, including invalid ones that attempt to move off the board.
## Scoring Tests: Check if player scores are correctly updated after each move.
## How to Run
The solution is structured to easily be compiled and tested. All JUnit tests are included in the source files to ensure that both basic and extended functionalities are working as expected.
