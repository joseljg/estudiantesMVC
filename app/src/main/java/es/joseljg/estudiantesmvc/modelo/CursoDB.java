package es.joseljg.estudiantesmvc.modelo;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import es.joseljg.estudiantesmvc.clases.Curso;


public class CursoDB {
    //-------------------------------------------------------------------------------
    public static ArrayList<Curso> obtenerCursos() {
        Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "SELECT * FROM cursos ORDER BY curso";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while(resultado.next())
            {
                String curso = resultado.getString("curso");
                String descripcion = resultado.getString("descripcion");
                Curso elcurso = new Curso(curso, descripcion);
                cursos.add(elcurso);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return cursos;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return cursos;
        }
    }
    //-------------------------------------------------------------------------------
    public static boolean guardarCurso(Curso c) {
        Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try {
            String ordensql = "INSERT INTO cursos (`curso`, `descripcion`) VALUES (?,?);";
            PreparedStatement sentencia = conexion.prepareStatement(ordensql);
            sentencia.setString(1, c.getCurso());
            sentencia.setString(2, c.getDescripcion());
            int filasafectadas = sentencia.executeUpdate();
            if(filasafectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
    //------------------------------------------------------------
    public static boolean borrarCurso(String elcurso) {
        Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try {
            String ordensql = "DELETE FROM `cursos` WHERE (`curso` = ?);";
            PreparedStatement sentencia = conexion.prepareStatement(ordensql);
            sentencia.setString(1, elcurso);
            int filasafectadas = sentencia.executeUpdate();
            if(filasafectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }

        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean actualizarCurso(Curso c, String cursoantiguo) {
        Connection conexion = ConfiguracionDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try {
            String ordensql = "UPDATE cursos SET curso = ?, descripcion = ? WHERE curso = ?";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, c.getCurso());
            pst.setString(2, c.getDescripcion());
            pst.setString(3, cursoantiguo);
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
    //-----------------------------------------------------------------------

}
