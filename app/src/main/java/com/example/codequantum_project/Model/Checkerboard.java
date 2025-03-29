package com.example.codequantum_project.Model;

public class Checkerboard {
    private Checker[][] board;

    public Checkerboard() {
        board = new Checker[8][8];
        setupBoard();
    }

    // Setup the board with the initial pieces for Player 1 and Player 2
    private void setupBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 8; col += 2) {
                board[row][col + (row % 2)] = new Checker(Checker.Player.PLAYER_ONE, Checker.PieceType.REGULAR);
            }
        }
        for (int row = 5; row < 8; row++) {
            for (int col = 0; col < 8; col += 2) {
                board[row][col + (row % 2)] = new Checker(Checker.Player.PLAYER_TWO, Checker.PieceType.REGULAR);
            }
        }
    }

    public Checker getPieceAt(int row, int col) {
        return board[row][col];
    }

    public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Checker.Player currentPlayer) {
        Checker piece = board[fromRow][fromCol];
        if (piece == null || piece.getPlayer() != currentPlayer) return false;
        if (toRow < 0 || toCol < 0 || toRow >= 8 || toCol >= 8 || board[toRow][toCol] != null) return false;

        // Regular piece can move one square diagonally
        if (piece.getType() == Checker.PieceType.REGULAR) {
            return Math.abs(fromRow - toRow) == 1 && Math.abs(fromCol - toCol) == 1;
        }

        // Add logic for kings here if needed later

        return false;
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        board[toRow][toCol] = board[fromRow][fromCol];
        board[fromRow][fromCol] = null;
    }
}