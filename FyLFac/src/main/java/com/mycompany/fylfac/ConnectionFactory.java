/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fylfac;

/**
 *
 * @author bere1
 */
// Factory
public class ConnectionFactory {
    public static Connection createConnection(String type) {
        if (type.equalsIgnoreCase("MySQL")) {
            return new MySQLConnection();
        } else if (type.equalsIgnoreCase("Oracle")) {
            return new OracleConnection();
        } else if (type.equalsIgnoreCase("PostgreSQL")) {
            return new PostgreSQLConnection();
        }
        return null; // o lanzar excepción
    }
}