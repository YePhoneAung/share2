package Lessons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Doom3D extends JPanel implements KeyListener {
    private double playerX = 3, playerY = 3, playerAngle = 0;
    private final double MOVE_SPEED = 0.1, ROTATE_SPEED = 0.05;
    private final int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
    };
    
    public Doom3D() {
        JFrame frame = new JFrame("3D Doom");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.addKeyListener(this);
        frame.setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw3DView(g);
    }
    
    private void draw3DView(Graphics g) {
        for (int x = 0; x < getWidth(); x++) {
            double rayAngle = (playerAngle - 0.5) + ((double) x / getWidth());
            double rayX = playerX, rayY = playerY;
            double rayStepX = Math.cos(rayAngle) * 0.05;
            double rayStepY = Math.sin(rayAngle) * 0.05;
            
            while (map[(int) rayY][(int) rayX] == 0) {
                rayX += rayStepX;
                rayY += rayStepY;
            }
            
            double distance = Math.sqrt(Math.pow(rayX - playerX, 2) + Math.pow(rayY - playerY, 2));
            int wallHeight = (int) (500 / distance);
            
            g.setColor(Color.GRAY);
            g.fillRect(x, (getHeight() / 2) - (wallHeight / 2), 1, wallHeight);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            playerX += Math.cos(playerAngle) * MOVE_SPEED;
            playerY += Math.sin(playerAngle) * MOVE_SPEED;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            playerX -= Math.cos(playerAngle) * MOVE_SPEED;
            playerY -= Math.sin(playerAngle) * MOVE_SPEED;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) playerAngle -= ROTATE_SPEED;
        if (e.getKeyCode() == KeyEvent.VK_D) playerAngle += ROTATE_SPEED;
        repaint();
    }
    
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    
    public static void main(String[] args) {
        new Doom3D();
    }
}
