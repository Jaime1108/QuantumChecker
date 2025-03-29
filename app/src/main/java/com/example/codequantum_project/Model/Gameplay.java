package com.example.codequantum_project.Model;

public class Gameplay {
    private Checker.Player currentPlayer;
    private Checkerboard checkerboard;

    public Gameplay() {
        currentPlayer = Checker.Player.PLAYER_ONE;
        checkerboard = new Checkerboard();
    }

    public void switchPlayer() {
        if (currentPlayer == Checker.Player.PLAYER_ONE) {
            currentPlayer = Checker.Player.PLAYER_TWO;
        } else {
            currentPlayer = Checker.Player.PLAYER_ONE;
        }
    }

    public boolean makeMove(int fromRow, int fromCol, int toRow, int toCol) {
        if (checkerboard.isValidMove(fromRow, fromCol, toRow, toCol, currentPlayer)) {
            checkerboard.movePiece(fromRow, fromCol, toRow, toCol);
            switchPlayer();
            return true;
        }
        return false;
    }

    public Checker.Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Checkerboard getCheckerboard() {
        return checkerboard;
    }
}
