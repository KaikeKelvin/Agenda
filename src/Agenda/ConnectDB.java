package Agenda;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectDB {

    private static final String URL = System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USER");
        private static final String PASS = System.getenv("DB_PASS");

        static{
            try{
                Class.forName("org.postgresql.Driver");
            }catch(ClassNotFoundException e){
                throw new RuntimeException("Driver SQL nâo encontrado", e);
            }
        }
        public static Connection getConnection() throws SQLException {
            DriverManager.setLoginTimeout(30);
            return DriverManager.getConnection(URL, USER, PASS);
        }
    }

