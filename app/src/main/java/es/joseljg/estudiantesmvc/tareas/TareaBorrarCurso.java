package es.joseljg.estudiantesmvc.tareas;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.clases.Curso;
import es.joseljg.estudiantesmvc.controladores.CursoController;
import es.joseljg.estudiantesmvc.modelo.CursoDB;


public class TareaBorrarCurso implements Callable<Boolean> {
    private String curso = null;

    public TareaBorrarCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            boolean borradoOK = CursoDB.borrarCurso(curso);
            return borradoOK;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
