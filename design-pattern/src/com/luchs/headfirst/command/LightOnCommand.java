package com.luchs.headfirst.command;

/**
 * @Author cheng
 * @Date 2020/12/19
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
