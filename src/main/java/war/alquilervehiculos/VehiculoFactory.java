
package war.alquilervehiculos;

public class VehiculoFactory implements VehiculoFactoryMethod{
    public Vehiculo createVehiculo(int tipo, String matricula, float kilometraje){
        switch(tipo){
            case 1: 
                return new Coche(tipo, matricula, kilometraje, false);
            case 2:
                return new Moto(tipo,matricula, kilometraje, false);
            case 3:
                return new Furgoneta(tipo,matricula, kilometraje, false);
            default:
                return null;
        }
    }  
}
