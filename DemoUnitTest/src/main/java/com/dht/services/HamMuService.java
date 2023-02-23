/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services;

/**
 *
 * @author admin
 */
public class HamMuService {

    public static double Power(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if (n > 0) {
            return x * Power(x, n - 1);
        } else {
            return Power(x, n + 1) / x;
        }
    }
}
