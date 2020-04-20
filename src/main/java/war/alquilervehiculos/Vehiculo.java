
package war.alquilervehiculos;

public abstract class Vehiculo {
    int tipo;
    String matricula;
    float kilometraje;
    boolean estado; //Indica si está alquilado o no;
    boolean extras = false;
    
    public Vehiculo(int tipo, String matricula, float kilometraje, boolean estado) {
        this.tipo = tipo;
        this.matricula = matricula;
        this.kilometraje = kilometraje;
        this.estado = estado;
    }

    public abstract int getTipo();
    public abstract String getMatricula();
    public abstract float getKilometraje();
    public abstract boolean getEstado();
    public abstract float getPrecioAlquiler(float kilometraje);
    
    public abstract void setTipo(int tipo);
    public abstract void setMatricula(String matricula);
    public abstract void setKilometraje(float kilometraje);
    public abstract void setEstado( boolean estado);
    public abstract void setExtras(boolean extras);
}
