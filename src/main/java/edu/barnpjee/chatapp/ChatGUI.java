package edu.barnpjee.chatapp;

import javax.swing.*;
import java.awt.*;


public class ChatGUI {

    private JTextArea area;

    protected void buildFrame() {
        JFrame frame = new JFrame("ChatGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        area = new JTextArea("Messages:\n");
        frame.getContentPane().add(area);

        frame.setLayout(new GridLayout(1, 1));
        frame.setSize(500, 800);

        frame.setVisible(true);
    }

    public void appendText(String text) {
        area.append(text);
    }

    public static void main(String[] args) {
        ChatGUI gui = new ChatGUI();
        gui.buildFrame();
    }

}
