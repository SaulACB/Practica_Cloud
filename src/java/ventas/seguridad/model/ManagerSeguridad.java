/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.seguridad.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ventas.model.entities.Usuario;
import ventas.seguridad.model.dto.LoginDTO;
import javax.ejb.Stateless;

/**
 *
 * @author Saul
 */
@Stateless
public class ManagerSeguridad {

    @PersistenceContext(unitName = "ventas_soaDS")
    private EntityManager em;

    //metodos de busqueda:
    public List<Usuario> findAllUsuario() {
        Query q = em.createNamedQuery("Usuario.findAll", Usuario.class);
        return q.getResultList();
    }

    public Usuario findUsuarioPorCorreo(String correo) throws Exception {
        Query q = em.createNamedQuery("Usuario.findByCorreo", Usuario.class);
        q.setParameter("correo", correo);
        return (Usuario) q.getSingleResult();
    }

    //crear nuevos usuarios:
    public void crearUsuario(String idUsuario, String nombres,
            String correo, String tipoUsuario) {
        Usuario u = new Usuario(idUsuario, nombres, tipoUsuario);
        u.setCorreo(correo);
        em.persist(u);
    }

    //TODO: metodos para eliminar y actualizar.
    /**
     * Metodo que permite verificar un usuario para autenticarse mediante su
     * correo.
     *
     * @param correo El correo del usuario.
     * @return Objeto DTO con informacion basica de login.
     * @throws Exception No se concreto la autenticacion.
     */
    public LoginDTO login(String correo) throws Exception {
        LoginDTO loginDTO = null;
        try {
            Usuario u = findUsuarioPorCorreo(correo);
            loginDTO = new LoginDTO(u.getIdUsuario(), u.getCorreo(),
                    u.getTipoUsuario());
            //ruta de acceso dependiendo del tipoUsuario:
            if (u.getTipoUsuario().equals("AD")) {
                loginDTO.setRutaWeb("administracion/index.xhtml");
            }
            if (u.getTipoUsuario().equals("VT")) {
                loginDTO.setRutaWeb("ventas/index.xhtml");
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            throw new Exception("Error en autenticación");
        }
        return loginDTO;
    }
}
