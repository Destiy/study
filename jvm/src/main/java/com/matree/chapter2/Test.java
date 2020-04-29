package com.matree.chapter2;

import lombok.Data;

/**
 * @author
 * @create 2020-04-28 8:14 PM
 */
public class Test {

    public static void main(String[] args) {
        Crie a = new Crie(1);
        Crie b = new Crie(2);
        swap1(a,b);
        System.out.println(a + " " + b);
    }

    public static void swap1(Crie a, Crie b) {
        Crie t = a;
        a = b;
        b = t;
    }

}
@Data
class Crie{
    double t;

    Crie(double t) {
        this.t = t;
    }
}