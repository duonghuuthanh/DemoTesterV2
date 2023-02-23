/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services;

/**
 *
 * @author admin
 */
public class BMIService {
    public static int tinhBMI(double cd, double cn) {
        double bmi = cn/Math.pow(cn, 2);
        if (bmi < 18.5)
            return 0;
        return 1;
    }
}
