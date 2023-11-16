package com.DragonXdroid.AdventureGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class KeyHandler extends KeyAdapter {
    private Set<Integer> pressedKeys = new HashSet<>();

    @Override
    public void keyPressed(KeyEvent e) {
        int keyPressed = e.getKeyCode();
        pressedKeys.add(keyPressed);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyReleased = e.getKeyCode();
        pressedKeys.remove(keyReleased);
    }

    public boolean isKeyPressed(int keyCode) {
        return pressedKeys.contains(keyCode);
    }

    public boolean isUpPressed() {
        return isKeyPressed(KeyEvent.VK_W);
    }

    public boolean isDownPressed() {
        return isKeyPressed(KeyEvent.VK_S);
    }

    public boolean isLeftPressed() {
        return isKeyPressed(KeyEvent.VK_A);
    }

    public boolean isRightPressed() {
        return isKeyPressed(KeyEvent.VK_D);
    }
}