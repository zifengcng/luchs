package com.luchs.headfirst.observe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author cheng
 * @Date 2020/12/16
 */
public class SwingObserve {

    JFrame jFrame;

    public static void main(String[] args) {
        SwingObserve swingObserve = new SwingObserve();
        swingObserve.go();
    }

    private void go() {
        jFrame = new JFrame("弹窗");
        JButton jButton = new JButton("点击");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("come on");
            }
        });
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("just do it");
            }
        });

        jFrame.getContentPane().add(BorderLayout.CENTER, jButton);
        jFrame.setSize(100, 100);
        jFrame.setVisible(true);
    }
}
