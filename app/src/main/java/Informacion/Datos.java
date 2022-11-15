package Informacion;

import android.os.Parcel;
import android.os.Parcelable;

public class Datos implements Parcelable {
    private String matricula;
    private String nombre;
    private int edad;
    private String semestre;
    private float promedio;
    private String estado;

    public Datos(String matricula, String nombre, int edad, String semestre, float promedio, String estado){
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.semestre = semestre;
        this.promedio = promedio;
        this.estado = estado;
    }

    protected Datos(Parcel in){
        matricula = in.readString();
        nombre = in.readString();
        edad = in.readInt();
        semestre = in.readString();
        promedio = in.readFloat();
        estado = in.readString();
    }

    public static final Creator<Datos> CREATOR = new Creator<Datos>() {
        @Override
        public Datos createFromParcel(Parcel in) {
            return new Datos(in);
        }

        @Override
        public Datos[] newArray(int size) {
            return new Datos[size];
        }
    };

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(matricula);
        parcel.writeString(nombre);
        parcel.writeInt(edad);
        parcel.writeString(semestre);
        parcel.writeFloat(promedio);
        parcel.writeString(estado);
    }
}
