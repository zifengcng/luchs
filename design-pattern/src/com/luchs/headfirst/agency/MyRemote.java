package com.luchs.headfirst.agency;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author cheng
 * @Date 2021/1/11
 */
public interface MyRemote extends Remote {

    String sayHello() throws RemoteException;
}
