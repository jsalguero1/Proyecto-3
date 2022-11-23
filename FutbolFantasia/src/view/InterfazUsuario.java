package view;

import java.util.Scanner;

public class InterfazUsuario {

    public static final Scanner input = new Scanner(System.in);
    
    /**
     * Pide el nombre de usuario para registrarlo
     * @return nombre ingresado por el usuario
     */
    public String pedirNombre(){
        System.out.print("Ingres tu nombre -> ");
        String nombre = input.nextLine();
        return nombre;
    }

    /**
     * Pide la clave que se va a asociar al nombre de usuario
     * @return la clave que ha ingresado el usuario
     */
    public String pedirClave(){
        System.out.print("Ingresa tu clave -> ");
        String clave = input.nextLine();
        return clave;
    }

    /**
     * Imprime los datos que se acaban de ingresar
     * @param _nombre nombre del usuario
     * @param _clave clave del usuario
     */
    public void imprimirRegistro(String _nombre, String _clave){
        System.out.println("Bienvenido " + _nombre + " tu clave es: " + _clave);
    }

    /**
     * Inicializa el menu principal de la aplicacion
     * @return opcion escogida por el jugador
     */
    public int iniciar(){
        System.out.println("Bienvenido a futbol fantasy");
        System.out.println("Que deseas hacer");
        System.out.println("1. Registrarte");
        System.out.println("2. Iniciar sesion");
        System.out.println("3. Salir");
        System.out.print("-> ");
        int opcion = Integer.parseInt(input.nextLine());
        return opcion;
    }
}
