package com.luchs.headfirst.compound.mvc;

/**
 * @Author cheng
 * @Date 2021/1/12
 */
public class DJtestDriver {

    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}
