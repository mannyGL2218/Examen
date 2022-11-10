package mx.edu.tesoem.isc.p2.rrja.m0079;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import Almacen.Archivos;
import Informacion.Datos;

public class actualizar extends AppCompatActivity {

    String seleccion;
    int index;
    EditText matricula, nombre, edad, semestre, promedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        matricula = findViewById(R.id.actualizar_matricula);
        nombre = findViewById(R.id.actualizar_nombre);
        edad = findViewById(R.id.actualizar_edad);
        semestre = findViewById(R.id.actualizar_semestre);
        promedio = findViewById(R.id.actualizar_promedio);

        seleccion = getIntent().getStringExtra("seleccion");
        index = Integer.parseInt(getIntent().getStringExtra("index"));

        Gson gson = new Gson();
        Datos datos = gson.fromJson(seleccion, Datos.class);

        matricula.setText(datos.getMatricula());
        nombre.setText(datos.getNombre());
        edad.setText(String.valueOf(datos.getEdad()));
        semestre.setText(datos.getSemestre());
        promedio.setText(String.valueOf(datos.getPromedio()));

    }
    public void btn_aceptar(View view){
        String estado;
        if(Float.parseFloat(promedio.getText().toString()) >= 70){
            estado = "Acreditado";
        } else {
            estado = "No acreditado";
        }

        Datos datos = new Datos(matricula.getText().toString(),nombre.getText().toString(),Integer.parseInt(edad.getText().toString()),semestre.getText().toString(),Float.parseFloat(promedio.getText().toString()),estado);
        Gson gson = new Gson();
        String cadena = gson.toJson(datos);

        Archivos archivos = new Archivos();

        if (archivos.Actualizar(this,index,cadena)){
            Toast.makeText(this,"Se grabo con exito", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Error al grabar", Toast.LENGTH_LONG).show();
        }
    }
    public void btn_cancelar(View view){
        Intent regreso = new Intent(this,principal.class);
        startActivity(regreso);
        finish();
    }
}