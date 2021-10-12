package com.example.utils;

import java.awt.*;

public class KeyEventUtils {
    public static void pressShift() {
        getRobot().keyPress(java.awt.event.KeyEvent.VK_SHIFT);
    }

    public static void releaseShift() {
        getRobot().keyRelease(java.awt.event.KeyEvent.VK_SHIFT);
    }

    public static void clickRight() {
        getRobot().keyPress(java.awt.event.KeyEvent.VK_RIGHT);
        getRobot().keyRelease(java.awt.event.KeyEvent.VK_RIGHT);
    }

    public static void clickLeft() {
        getRobot().keyPress(java.awt.event.KeyEvent.VK_LEFT);
        getRobot().keyRelease(java.awt.event.KeyEvent.VK_LEFT);
    }

    private static Robot getRobot() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return robot;
    }
}
