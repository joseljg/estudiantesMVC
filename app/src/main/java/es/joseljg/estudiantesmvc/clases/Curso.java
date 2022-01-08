package es.joseljg.estudiantesmvc.clases;


import java.io.Serializable;
import java.util.Objects;

public class Curso implements Serializable {
    //-----------------------------------------------

    private String curso;
    private String descripcion;

    //-----------------------------------------------
    public Curso(String curso, String descripcion) {
        this.curso = curso;
        this.descripcion = descripcion;
    }
    //-----------------------------------------------

    public String getCurso() {
        return curso;
    }

    public void setCurso( String curso) {
        this.curso = curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(  String descripcion) {
        this.descripcion = descripcion;
    }
    //-------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;
        Curso curso1 = (Curso) o;
        return curso.equals(curso1.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(curso);
    }
    //--------------------------------------------------

    @Override
    public String toString() {
 /*       return "Curso{" +
                "curso='" + curso + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
                */
    return this.curso;
    }

    //--------------------------------------------------
}
