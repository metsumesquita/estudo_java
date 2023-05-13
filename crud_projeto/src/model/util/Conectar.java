package model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String password = "CatliuX";
    private String user = "postgres";




    public Connection getConnection() {
        Connection conectando = null;

        try {

            Class.forName("org.postgresql.Driver");
            conectando = DriverManager.getConnection(url, user, password);
            if (conectando != null) {
                System.out.println("Banco conectador");
            }
        } catch (Exception ex) {

            System.out.println("Erro de conexao como banco " + ex.getMessage());

        }
        return conectando;
    }




    public void fecharConexao(Connection conn) {
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }


    }

}
