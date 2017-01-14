package ru.ege.curve;

public class Main {

    public static void main(String[] args) {
        MyJFrame mjf = new MyJFrame();
        mjf.addMouseListener(mjf);
        mjf.startDrawingThread();
    }
}
