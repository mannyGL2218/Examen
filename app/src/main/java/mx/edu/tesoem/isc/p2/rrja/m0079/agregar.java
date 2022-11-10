package mx.edu.tesoem.isc.p2.rrja.m0079;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import Almacen.Archivos;
import Informacion.Datos;

import java.util.ArrayList;
import java.util.List;

public class agregar extends AppCompatActivity {

    EditText matricula, nombre, edad, semestre, promedio;
    List<String> informacion = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        matricula = findViewById(R.id.agregar_matricula);
        nombre = findViewById(R.id.agregar_nombre);
        edad = findViewById(R.id.agregar_edad);
        semestre = findViewById(R.id.agregar_semestre);
        promedio = findViewById(R.id.agregar_promedio);
    }

    public void agregar(View view){
        String estado;
        if(Float.parseFloat(promedio.getText().toString()) >= 70){
            estado = "Acreditado";
        } else {
            estado = "No acreditado";
        }

        Datos datos = new Datos(matricula.getText().toString(),nombre.getText().toString(),Integer.parseInt(edad.getText().toString()),semestre.getText().toString(),Float.parseFloat(promedio.getText().toString()),estado);
        Gson gson = new Gson();
        String cadena = gson.toJson(datos);

        informacion.add(cadena);
        Archivos archivos = new Archivos();

        if (archivos.Grabar(this,informacion)){
            Toast.makeText(this,"Se grabo con exito", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Error al grabar", Toast.LENGTH_LONG).show();
        }

    }

}