
package war.alquilervehiculos;


public class Coche extends Vehiculo{

    public Coche(int tipo, String matricula, float kilometraje, boolean estado) {
        super(tipo, matricula, kilometraje, estado);
    }


    //Getters
    @Override
    public int getTipo() {
        return this.tipo;
    }

    @Override
    public String getMatricula() {
        return this.matricula;
    }

    @Override
    public float getKilometraje() {
        return this.kilometraje;
    }

    @Override
    public boolean getEstado() {
        return this.estado;
    }

    @Override
    public float getPrecioAlquiler(float kilometraje) {
        if(extras)
            return (float) (( kilometraje * 0.4) + 20.0);
        else
            return (float) ( kilometraje * 0.4);

    }

    //setters

    @Override
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public void setKilometraje(float kilometraje) {
        this.kilometraje = this.kilometraje + kilometraje;
    }

    @Override
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public void setExtras(boolean extras){
    	this.extras = extras;
    }
    
}
