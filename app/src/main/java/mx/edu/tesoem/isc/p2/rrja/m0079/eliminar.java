package mx.edu.tesoem.isc.p2.rrja.m0079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import Almacen.Archivos;
import Informacion.Datos;

public class eliminar extends AppCompatActivity {

    EditText matricula, nombre, edad, semestre, promedio, estado;
    String seleccion;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        matricula = findViewById(R.id.eliminar_matricula);
        nombre = findViewById(R.id.eliminar_nombre);
        edad = findViewById(R.id.eliminar_edad);
        semestre = findViewById(R.id.eliminar_semestre);
        promedio = findViewById(R.id.eliminar_promedio);
        estado = findViewById(R.id.eliminar_estado);

        seleccion = getIntent().getStringExtra("seleccion");
        index = Integer.parseInt(getIntent().getStringExtra("index"));

        Gson gson = new Gson();
        Datos datos = gson.fromJson(seleccion, Datos.class);

        matricula.setText(datos.getMatricula());
        nombre.setText(datos.getNombre());
        edad.setText(String.valueOf(datos.getEdad()));
        semestre.setText(datos.getSemestre());
        promedio.setText(String.valueOf(datos.getPromedio()));
        estado.setText(datos.getEstado());
    }
    public void btn_cancelar(View view){
        Intent regreso = new Intent(this,principal.class);
        startActivity(regreso);
        finish();
    }
    public void btn_aceptar(View view){
        //Toast.makeText(this, seleccion, Toast.LENGTH_LONG).show();
        Archivos archivos = new Archivos();
        if (archivos.EliminarRegistro(this,index)){
            Toast.makeText(this,"Eliminado con exito",Toast.LENGTH_LONG).show();
        }
        Intent regreso = new Intent(this,principal.class);
        startActivity(regreso);
        finish();
    }

}