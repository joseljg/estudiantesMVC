package es.joseljg.estudiantesmvc.tareas;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.clases.Curso;
import es.joseljg.estudiantesmvc.modelo.CursoDB;


public class TareaObtenerCursos implements Callable<ArrayList<Curso>> {

    @Override
    public ArrayList<Curso> call() throws Exception {
        ArrayList<Curso> cursos= CursoDB.obtenerCursos();
        return cursos;
    }
}
