package BrickBreaker;

import javax.swing.*;

public class Main   {

    public static void main(String[] args) {
        JFrame frame = new JFrame("BrickBreaker");
        GameController game = new GameController();
        frame.setBounds(10, 20, 700, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.setVisible(true);
    }

}
