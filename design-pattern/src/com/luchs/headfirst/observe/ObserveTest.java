package com.luchs.headfirst.observe;

/**
 * @Author cheng
 * @Date 2020/12/16
 */
public class ObserveTest {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();


        Observer curr = new CurrObserver(weatherData);
        Observer duck = new DuckObserver(weatherData);

        weatherData.setNumber(1);
        weatherData.setNumber(100);

        weatherData.delete(duck);
        weatherData.setNumber(1000);
    }
}
