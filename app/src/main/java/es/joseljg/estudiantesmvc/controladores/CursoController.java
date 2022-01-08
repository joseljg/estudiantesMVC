package es.joseljg.estudiantesmvc.controladores;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import es.joseljg.estudiantesmvc.clases.Curso;
import es.joseljg.estudiantesmvc.tareas.TareaActualizarCurso;
import es.joseljg.estudiantesmvc.tareas.TareaBorrarCurso;
import es.joseljg.estudiantesmvc.tareas.TareaInsertarCurso;
import es.joseljg.estudiantesmvc.tareas.TareaObtenerCursos;

public class CursoController {

    //------------------------------------------------------------------------------------------
    public static ArrayList<Curso>  obtenercursos() {
        ArrayList<Curso> cursos = null;
        FutureTask t = new FutureTask (new TareaObtenerCursos());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            cursos= (ArrayList<Curso>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(2000, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cursos;
    }
    //------------------------------------------------------------------------------------------

    public static boolean insertarCurso(Curso c)
    {
        FutureTask t = new FutureTask(new TareaInsertarCurso(c));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try {
            insercionOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return insercionOK;
        }
    }
    //------------------------------------------------------------------------------------------
    public static boolean borrarCurso(String curso)
    {
        FutureTask t = new FutureTask(new TareaBorrarCurso(curso));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return borradoOK;
        }
    }
    //------------------------------------------------------------------------------------------
    public static boolean actualizarCurso(Curso c, String cursoantiguo) {
        FutureTask t = new FutureTask(new TareaActualizarCurso(c, cursoantiguo));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean actualizadoOK = false;
        try {
            actualizadoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return actualizadoOK;
        }
    }
}
