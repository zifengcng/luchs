package com.luchs.headfirst.command;


/**
 * @Author cheng
 * @Date 2020/12/19
 */
public class SimpleRemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl control = new SimpleRemoteControl();
        control.setCommand(new LightOnCommand(new Light() {
            @Override
            public void on() {
                System.out.println("客厅灯打开了");
            }

            @Override
            public void off() {
                System.out.println("客厅灯关上了");
            }
        }));
        control.buttonWasPressed();
    }

}