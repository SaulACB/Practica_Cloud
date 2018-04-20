/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.seguridad.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import ventas.seguridad.model.ManagerSeguridad;
import ventas.seguridad.model.dto.LoginDTO;

/**
 *
 * @author Saul
 */
@ManagedBean
@SessionScoped
public class ControllerSeguridad {

    private String correo;
    private LoginDTO loginDTO;
    @EJB
    private ManagerSeguridad managerSeguridad;

    public String actionLogin() {
        loginDTO = null;
        try {
            loginDTO = managerSeguridad.login(correo);
            //si el acceso es correcto, se navega a la pg correspondiente:
            return loginDTO.getRutaWeb();
        } catch (Exception ex) {
            FacesMessage msg = new FacesMessage(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(correo, msg);
        }

        return "";
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LoginDTO getLoginDTO() {
        return loginDTO;
    }
}
