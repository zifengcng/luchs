package com.luchs.headfirst.compound.mvc;

/**
 * @Author cheng
 * @Date 2021/1/12
 */
public interface ControllerInterface {

    void start();

    void stop();

    void increaseBPM();

    void decreaseBPM();

    void setBPM(int bpm);
}
