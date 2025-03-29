package com.example.codequantum_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.codequantum_project.Model.Checker;
import com.example.codequantum_project.Model.Gameplay;

public class MainActivity extends AppCompatActivity {

    private Gameplay gameplay;
    private GridLayout boardGrid;
    private Position selectedPiece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the gameplay object and board grid
        gameplay = new Gameplay();
        boardGrid = findViewById(R.id.boardGrid);
        selectedPiece = null;

        // Dynamically create buttons for the 8x8 grid
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Button button = new Button(this);
                button.setLayoutParams(new GridLayout.LayoutParams());
                boardGrid.addView(button);

                // Set the background color for the square (light or dark)
                if ((row + col) % 2 == 0) {
                    button.setBackgroundResource(R.drawable.light_square);
                } else {
                    button.setBackgroundResource(R.drawable.dark_square);
                }

                // Set the click listener for each button
                final int finalRow = row;
                final int finalCol = col;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onSquareClicked(finalRow, finalCol, button);
                    }
                });
            }
        }
    }

    // Handle the logic for clicking on a square
    private void onSquareClicked(int row, int col, Button button) {
        if (selectedPiece != null) {
            int fromRow = selectedPiece.getRow();
            int fromCol = selectedPiece.getCol();
            if (gameplay.makeMove(fromRow, fromCol, row, col)) {
                updateBoard();
            }
            selectedPiece = null;
        } else {
            selectedPiece = new Position(row, col);
        }
    }

    // Update the UI with the pieces' positions
    private void updateBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Button button = (Button) boardGrid.getChildAt(row * 8 + col);
                Checker piece = gameplay.getCheckerboard().getPieceAt(row, col);
                if (piece != null) {
                    if (piece.getPlayer() == Checker.Player.PLAYER_ONE) {
                        button.setBackgroundResource(R.drawable.piece_player1);
                    } else {
                        button.setBackgroundResource(R.drawable.piece_player2);
                    }
                }
            }
        }
    }
}
