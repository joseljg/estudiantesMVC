package es.joseljg.estudiantesmvc.tareas;

import java.util.concurrent.Callable;

import es.joseljg.estudiantesmvc.clases.Curso;
import es.joseljg.estudiantesmvc.modelo.CursoDB;


public class TareaInsertarCurso implements Callable<Boolean> {
    private Curso c = null;

    public TareaInsertarCurso(Curso c) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        try{
            boolean insercionOK = CursoDB.guardarCurso(c);
            return insercionOK;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
