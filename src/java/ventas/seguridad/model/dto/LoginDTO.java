/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.seguridad.model.dto;

/**
 *
 * @author Saul
 */
public class LoginDTO {
     private String idUsuario;     
     private String correo;     
     private String tipoUsuario;        
     private String rutaWeb;

    public LoginDTO(String idUsuario, String correo, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getRutaWeb() {
        return rutaWeb;
    }

    public void setRutaWeb(String rutaWeb) {
        this.rutaWeb = rutaWeb;
    }    
}
