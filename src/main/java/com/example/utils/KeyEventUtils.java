package com.example.utils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyEventUtils {

    public static void pressShift() {
        getRobot().keyPress(KeyEvent.VK_SHIFT);
    }

    public static void releaseShift() {
        getRobot().keyRelease(KeyEvent.VK_SHIFT);
    }

    public static void clickRight() {
        getRobot().keyPress(KeyEvent.VK_RIGHT);
        getRobot().keyRelease(KeyEvent.VK_RIGHT);
    }

    public static void clickLeft() {
        getRobot().keyPress(KeyEvent.VK_LEFT);
        getRobot().keyRelease(KeyEvent.VK_LEFT);
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