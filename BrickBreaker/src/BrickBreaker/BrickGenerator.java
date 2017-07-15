package BrickBreaker;

import java.awt.*;

public class BrickGenerator {
    public int grid[][];
    public int brickWidth;
    public int brickHeight;

    public BrickGenerator(int row, int col) {
        grid = new int[row][col];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                //one denotes that the brick exists at that location
                grid[i][j] = 1;

            }
        }

        brickWidth = 540/col;
        brickHeight = 150/row;
    }

    public void draw(Graphics2D g) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] > 0) {
                    //bricks
                    g.setColor(Color.white);
                    g.fillRect(j*brickWidth+80, i*brickHeight+40, brickWidth, brickHeight);

                    //border
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*brickWidth+80, i*brickHeight+40, brickWidth, brickHeight);
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col) {
        grid[row][col] = value;
    }
}
