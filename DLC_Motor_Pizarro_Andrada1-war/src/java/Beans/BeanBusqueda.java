/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import BO.BusquedaImplBO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
/**
 *
 * @author Juaco
 */

public class BeanBusqueda {

    private List<BeanBusqueda> listaBusqueda;
    private BusquedaImplBO busquedaBO;

    public List<BeanBusqueda> getListaBusqueda() {
        return listaBusqueda;
    }

    public void setListaBusqueda(List<BeanBusqueda> listaBusqueda) {
        this.listaBusqueda = listaBusqueda;
    }

    public BusquedaImplBO getBusquedaBO() {
        return busquedaBO;
    }

    public void setBusquedaBO(BusquedaImplBO busquedaBO) {
        this.busquedaBO = busquedaBO;
    }
    
    public String validarBusqueda()
    {
        getBusquedaBO().validaBusqueda(this);
        
        if(this.getStatus())
        {
            ExternalContext externalContext= FacesContext.getCurrentInstance().getExternalContext();
            Map<String , Object> sessionMap = externalContext.getSessionMap();
            setListaBusqueda(new ArrayList<BeanBusqueda>());
            sessionMap.put("listaBusqueda",getListaBusqueda());
            return alumnos/alumnos;
        
        }else{return login;}
        
    
    }
    
    
    
}
