package mainApp;

import models.Modelo;
import models.ModeloConexion;
import views.*;
import controllers.*;

public class App 
{
    public static void main( String[] args )
    {
        Modelo modelo = new Modelo();
        ModeloConexion modeloconexion = new ModeloConexion();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo,modeloconexion,vista);
        controlador.iniciarVista();
    }
}
