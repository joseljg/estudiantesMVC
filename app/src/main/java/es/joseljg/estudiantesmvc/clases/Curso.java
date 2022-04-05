package es.joseljg.estudiantesmvc.clases;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Objects;

public class Curso implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.curso);
        dest.writeString(this.descripcion);
    }

    public void readFromParcel(Parcel source) {
        this.curso = source.readString();
        this.descripcion = source.readString();
    }

    protected Curso(Parcel in) {
        this.curso = in.readString();
        this.descripcion = in.readString();
    }

    public static final Creator<Curso> CREATOR = new Creator<Curso>() {
        @Override
        public Curso createFromParcel(Parcel source) {
            return new Curso(source);
        }

        @Override
        public Curso[] newArray(int size) {
            return new Curso[size];
        }
    };
}
