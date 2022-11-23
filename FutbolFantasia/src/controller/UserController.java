package controller;

import BaseDatos.GuardaDatos;
import model.Participante;
import view.InterfazUsuario;

public class UserController {

    private InterfazUsuario view;
    private GuardaDatos baseDatos;

    /**
     * Constructor del controlador de usuario
     * @param _view Vista asociada a este controlador
     */
    public UserController(InterfazUsuario _view, GuardaDatos _baseDatos){
        this.view = _view;
        this.baseDatos = _baseDatos;
    }

    /**
     * Registra a un usuario
     */
    public void registrarUsuario(){
        String nombre = view.pedirNombre();
        String clave = view.pedirClave();
        Participante participante = new Participante(nombre, clave);
        baseDatos.guardarParticipante(participante);
        participante = baseDatos.recuperarparticipante(nombre, clave);
        view.imprimirRegistro(participante.getNombre(), participante.getClave());
        iniciar();
    }

    /**
     * Inicia sesion como participante al ingresar nombre de usuario y claves que coincidan con un registro
     */
    public void iniciarSesion(){
        String nombre = view.pedirNombre();
        String clave = view.pedirClave();
        Participante participante = baseDatos.recuperarparticipante(nombre, clave);
        if(participante == null){
            System.out.println("NO existe");
            iniciar();
        }else{
            view.imprimirRegistro(participante.getNombre(), participante.getClave());
            iniciar();
        } 
    }

    /**
     * Ejecuta un metodo dependiendo de la opcion escogida
     */
    public void iniciar(){
        int opcion = view.iniciar();
        switch (opcion) {
            case 1:
                registrarUsuario();
                break;
            case 2:
                iniciarSesion();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                iniciar();
                break;
        }
    }
}
