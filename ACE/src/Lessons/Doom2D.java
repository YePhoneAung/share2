package Lessons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Doom2D extends JPanel implements KeyListener {
    private int playerX = 100, playerY = 100;
    private int playerAngle = 0;
    private final int SPEED = 5;
    private final int[][] map = {
            {1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1},
    };
    
    public Doom2D() {
        JFrame frame = new JFrame("2D Doom");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.addKeyListener(this);
        frame.setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMap(g);
        drawPlayer(g);
    }
    
    private void drawMap(Graphics g) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == 1) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                }
                g.fillRect(x * 50, y * 50, 50, 50);
                g.setColor(Color.WHITE);
                g.drawRect(x * 50, y * 50, 50, 50);
            }
        }
    }
    
    private void drawPlayer(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(playerX, playerY, 10, 10);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) playerY -= SPEED;
        if (e.getKeyCode() == KeyEvent.VK_S) playerY += SPEED;
        if (e.getKeyCode() == KeyEvent.VK_A) playerX -= SPEED;
        if (e.getKeyCode() == KeyEvent.VK_D) playerX += SPEED;
        repaint();
    }
    
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    
    public static void main(String[] args) {
        new Doom2D();
    }
}
