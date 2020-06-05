package edu.barnpjee.chatapp;


public class ChatApp implements BurlapJunction {

    private String messages = "START";
    private final ChatGUI gui;

    public ChatApp() {
        gui = new ChatGUI();
        gui.buildFrame();
    }

    @Override
    public String readMessages() {
        return messages;
    }

    @Override
    public void writeMessages(String msg) {
        messages += " | " + msg;
        gui.appendText(msg);
    }

}
