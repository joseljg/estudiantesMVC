package es.joseljg.estudiantesmvc.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import es.joseljg.estudiantesmvc.R;
import es.joseljg.estudiantesmvc.clases.Curso;
import es.joseljg.estudiantesmvc.controladores.CursoController;

public class BorrarCursoActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    private Spinner sp_borrar_curso = null;
    private Curso cseleccionado = null;
    private ArrayAdapter<Curso> adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_curso);
        sp_borrar_curso = (Spinner) findViewById(R.id.sp_borrar_curso);
        sp_borrar_curso.setOnItemSelectedListener(this);
        //-----------------------------------------------------------
        ArrayList<Curso> cursos = CursoController.obtenercursos();
        if(cursos != null) {
           asignarAdaptadorSpinnerCursos(cursos);
        }
        else{
            Toast.makeText(this, "no hay cursos", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void asignarAdaptadorSpinnerCursos(ArrayList<Curso> cursos) {
        adapter = new ArrayAdapter<Curso>(this , R.layout.item_curso, cursos);
        sp_borrar_curso.setAdapter(adapter);
    }

    public void borrarCurso(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("De verdad quieres borrar el curso?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(cseleccionado == null)
                {
                    mostrarToast("selecciona un curso");
                    return;
                }
                //borrar provincia
                boolean borradoOK = CursoController.borrarCurso(cseleccionado.getCurso());
                if(borradoOK)
                {
                    mostrarToast("curso borrado correctamente");
                    // actualizamos el spinner (como el livedata)
                    ArrayList<Curso> cursos = CursoController.obtenercursos();
                    asignarAdaptadorSpinnerCursos(cursos);
                }
                else{
                    mostrarToast("el curso no se pudo borrar");
                }
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Curso c = (Curso) sp_borrar_curso.getItemAtPosition(position);
        cseleccionado = c;
      //  Toast.makeText(this, c.getCurso(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}