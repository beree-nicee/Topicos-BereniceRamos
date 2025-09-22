/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.fylfac;

/**
 *
 * @author bere1
 */



// Clase Main para probar
public class FyLFac {
    public static void main(String[] args) {
        Connection conn1 = ConnectionFactory.createConnection("MySQL");
        conn1.connect();

        Connection conn2 = ConnectionFactory.createConnection("Oracle");
        conn2.connect();

        Connection conn3 = ConnectionFactory.createConnection("PostgreSQL");
        conn3.connect();
    }
}



