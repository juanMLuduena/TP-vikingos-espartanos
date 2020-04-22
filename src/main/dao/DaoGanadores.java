package main.dao;

import main.model.Ganador;
import main.model.Humano;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DaoGanadores {
    //ACA SI NO ANDA ES POR EL CJ
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/torneoPintas";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";


    Connection conexion;
    static DaoGanadores instance;

    public static DaoGanadores getInstance() {
        if (instance == null) {
            instance = new DaoGanadores();
        }
        return instance;
    }

    public DaoGanadores() {
        try {
            // Se establece la conexiÃ³n con la base de datos
            conexion = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Se crea la base de datos y la tabla si no existe
            Statement st = conexion.createStatement();
            st.execute("create database if not exists torneoPintas;");
            st.execute("create table if not exists ganadores(" +
                    "id_ganador int auto_increment unique," +
                    "nombre_ganador varchar(50)," +
                    "bebida_en_cuerpo int," +
                    "constraint pk_ganador primary key (id_ganador)" +
                    ");");
            conexion.close();
            conexion = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Ganador> listarGanadores() {
        try {
            Statement st = conexion.createStatement();
            String sql = "select * from ganadores";
            ResultSet rs = st.executeQuery(sql);
            List<Ganador> lista = new ArrayList<Ganador>();
            while (rs.next()) {
                Ganador g = new Ganador(rs.getInt("id_ganador"), rs.getString("nombre_ganador"), rs.getInt("bebida_en_cuerpo"));
                lista.add(g);
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void agregarGanador(Humano h) {
        try {
            String sql = "insert into ganadores(nombre_ganador, bebida_en_cuerpo) values (?,?)";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, h.getNombre());
            st.setInt(2, h.getVejiga());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


