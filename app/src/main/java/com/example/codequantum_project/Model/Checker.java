package com.example.codequantum_project.Model;

public class Checker {
    public enum Player {
        PLAYER_ONE,
        PLAYER_TWO
    }

    public enum PieceType {
        KING,
        REGULAR
    }

    private Player player;
    private PieceType type;

    public Checker(Player player, PieceType type) {
        this.player = player;
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }
}
