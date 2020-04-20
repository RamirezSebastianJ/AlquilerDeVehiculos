
package war.alquilervehiculos;

import java.util.ArrayList;
import java.util.Scanner;


public class Principal {
    
    private static Vehiculo auxiliar;
    private static VehiculoFactoryMethod factory = new VehiculoFactory();
    private static ArrayList <Vehiculo> vehiculos  = new ArrayList<Vehiculo>();
    
    public static void main(String[] args) {
        while(true){
            Menu();
        }
    }

    public static void Menu(){
        int opcion;
        String matricula;
        float kilometraje;
        String extra;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Qué desea hacer?"
                + "\n1. Registrar Vehiculos"
                + "\n2. Alquilar Vehiculos"
                + "\n3. Recibir Vehiculos"
                + "\n4. Dar de baja algun vehiculo"
                + "\n5. Salir"
            );
        opcion = entrada.nextInt();
        
        switch(opcion){
            case 1:
                System.out.println("Qué tipo de vehiculo quiere registrar?"
                    + "\n1. coche"
                    + "\n2. moto"
                    + "\n3. furgoneta"
                    );
                entrada.nextLine();
                opcion = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Matricula: ");
                matricula = entrada.nextLine();
                System.out.println("Kilometraje");
                kilometraje = entrada.nextFloat();
               
                auxiliar = factory.createVehiculo(opcion, matricula, kilometraje);
                vehiculos.add(auxiliar);
                auxiliar = null;
                
                break;
                
            case 2:
                System.out.println("Qué tipo de vehiculo quiere Alquilar?"
                    + "\n1. coche"
                    + "\n2. moto"
                    + "\n3. furgoneta"
                    );
                entrada.nextLine();
                opcion = entrada.nextInt();

                if(opcion>=1 && opcion <=3){
                
                    for (int i = 0; i < vehiculos.size() ; i++ ) {
                        auxiliar = vehiculos.get(i);
                        int tipo = auxiliar.getTipo();
                        if(tipo ==  opcion)
                            if(!auxiliar.getEstado())
                                System.out.println("Placa: " + auxiliar.getMatricula()
                                    + "\nMatricula: " + auxiliar.getKilometraje()
                                    + "\n-------------------"
                                );
                    }
                }else{
                    break;
                }
                
                System.out.println("Ingrese la matricula del vehiculo a elegir: ");
                entrada.nextLine();
                matricula = entrada.nextLine();

                for (int i = 0; i < vehiculos.size() ; i++ ) {

                    auxiliar = vehiculos.get(i);

                    if(!auxiliar.getEstado()){
                    	
                        if(matricula.equals(auxiliar.getMatricula())){
                            System.out.println("\n++++++++++" + auxiliar.getMatricula());
                            if(opcion == 1){
                            	System.out.println("Desea Llevar extras ?"
                            		+ "\nRecuerde que este tiene un valor adicional de 20 £"
                            		+ "\ns/n"
                            		);
                            }
                            if(opcion == 2){
                            	System.out.println("Desea Llevar casco ?"
                            		+ "\nRecuerde que este tiene un valor adicional de 10 £"
                            		+ "\ns/n"
                            		);
                            }
                            extra = entrada.nextLine();
                            if(extra == "s" | extra == "S"){
                                auxiliar.setExtras(true);
                            }
                            
                            auxiliar.setEstado(true);
                            vehiculos.add(i, auxiliar);

                            System.out.println(
                            	"Haz Alquilado el vehiculo"
                            	+ "\nPlaca: " + auxiliar.getMatricula()
                                + "\nMatricula: " + auxiliar.getKilometraje()
                                + "\n-------------------"
                            );
                        }
                    }
                }
            	break;
            case 3:
                System.out.println("Ingrese la Matricula del vehiculo a entregar: ");
                entrada.nextLine();
                matricula = entrada.nextLine();


                for (int i = 0; i < vehiculos.size() ; i++ ) {
                    auxiliar = vehiculos.get(i);
                    String auxiliarMatricula = auxiliar.getMatricula();
                    if(auxiliarMatricula.equals(matricula)){
                        if(auxiliar.getEstado()){
                            System.out.println("Cual es el kilometraje actual?");
                            kilometraje = entrada.nextFloat();

                            System.out.println("El valor a pagar es: " + auxiliar.getPrecioAlquiler(kilometraje) + "£");
                            auxiliar.setKilometraje(kilometraje);
                            auxiliar.setEstado(false);
                            auxiliar.setExtras(false);
                            vehiculos.add(i, auxiliar);
                            i = vehiculos.size() + 1; 
                        }else
                            System.out.println("El vehiculo no está alquilado");
                    } 
                }
                break;

            case 4:
            	System.out.println("Ingrese la Matricula del vehiculo a eliminar: ");
                matricula = entrada.nextLine();
            
                for (int i = 0; i < vehiculos.size() ; i++ ) {
                    auxiliar = vehiculos.get(i);
                    String auxiliarMatricula = auxiliar.getMatricula();
                    if(auxiliarMatricula.equals(matricula)){
                    	vehiculos.remove(i);
                    	i = vehiculos.size() + 1; 
                    }else
                        System.out.println("El vehiculo no pertenece a la empresa");
                }
            	break;
                
            case 5:
            	System.exit(0);
            	break;
                
            default:
                System.out.println("Opcion Incorrecta");
        }
        
    }
}
