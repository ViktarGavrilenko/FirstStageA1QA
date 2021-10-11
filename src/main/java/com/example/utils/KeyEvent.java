package com.example.utils;

import java.awt.*;

public class KeyEvent {
    public static void pressShift() {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(java.awt.event.KeyEvent.VK_SHIFT);
    }

    public static void releaseShift() {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyRelease(java.awt.event.KeyEvent.VK_SHIFT);
    }

    public static void clickRight() {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(java.awt.event.KeyEvent.VK_RIGHT);
        r.keyRelease(java.awt.event.KeyEvent.VK_RIGHT);
    }

    public static void clickLeft() {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(java.awt.event.KeyEvent.VK_LEFT);
        r.keyRelease(java.awt.event.KeyEvent.VK_LEFT);
    }
}
