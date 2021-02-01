package com.source.workman.designMode.chain;

public class EventHandler extends AbstractHandler implements Handler {

    private String name;

    public EventHandler(String name) {
        this.name = name;
    }

    @Override
    public void action() {
        System.out.println("handler [" + name + "] -> called.");
        if (getHandler() != null) {
            getHandler().action();
        }
    }

    public static void main(String[] args) {
        EventHandler doubleClickHandler = new EventHandler("doubleclick event");
        EventHandler clickHandler = new EventHandler("click event");
        EventHandler mouseHandler = new EventHandler("mouse event");

        doubleClickHandler.setHandler(clickHandler);
        clickHandler.setHandler(mouseHandler);

        doubleClickHandler.action();
    }
}
