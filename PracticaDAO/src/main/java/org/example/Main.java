package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospitaldb",
                    "topicos",
                    "TopicosProgra#$"
            );
            System.out.println("✅ Conexión exitosa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
