/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;
import BO.BusquedaBO;
import Beans.BeanBusqueda;

/**
 *
 * @author Juaco
 */
// Esta es la capa de negocio en la cual vamos a mapear los java beans con nuestra base de datos.

public class BusquedaImplBO implements BusquedaBO{
    
    private ImplBusqueda busquedaDAO;

   
    public ImplBusqueda getBusqeudaDAO(){
    return busquedaDAO;
    }
    public void setBusquedaDAO(ImplBusqueda busquedaDAO)
    {
    this.busquedaDAO= busquedaDAO;
    }

    @Override
    public void validaBusqueda(BeanBusqueda obj) {
         Busqueda busqueda= new Busqueda();
        busqueda= getBusquedaDAO().validarBusqueda(busqueda);
        if(busqueda!= null){
        obj.setStatus(true);
        obj.setMensaje("Busqueda realizada con exito");
        }else{
        obj.setStatus(false);
        obj.setMensaje("Busqueda erronea");
        }
            
        
    }
}
