package com.luchs.headfirst.command;

/**
 * @Author cheng
 * @Date 2020/12/19
 */
public class SimpleRemoteControl {

    private Command slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }

}
