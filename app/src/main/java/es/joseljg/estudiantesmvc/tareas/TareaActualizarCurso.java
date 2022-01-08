package es.joseljg.estudiantesmvc.tareas;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.clases.Curso;
import es.joseljg.estudiantesmvc.modelo.CursoDB;


public class TareaActualizarCurso implements Callable<Boolean> {
    private Curso c = null;
    private String cursoantiguo = null;

    public TareaActualizarCurso(Curso c, String cursoantiguo) {
        this.c = c;
        this.cursoantiguo = cursoantiguo;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            boolean actualizadoOK = CursoDB.actualizarCurso(c, cursoantiguo);
            return actualizadoOK;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
