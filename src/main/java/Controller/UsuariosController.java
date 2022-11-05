package Controller;

import DAO.UsuariosDAO;
import Model.EnumAccesoLista;
import Model.EnumTipoLista;
import Model.Usuarios;
import Enum.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "usuarios", urlPatterns = {
        "/usuarios/nuevoUsuarios","/usuarios/insertarUsuarios","/usuarios/borrarUsuarios","/usuarios/editarUsuarios","/usuarios/actualizarUsuarios","/usuarios/listarUsuarios"})
public class UsuariosController extends HttpServlet {
    private UsuariosDAO usuariosDao;

    public void init() {
        usuariosDao = new UsuariosDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/usuarios/nuevoUsuarios":
                    System.out.println("Not done");
                    showNewFormUsuarios(request, response);
                    break;
                case "/usuarios/insertarUsuarios":
                    insertUsuarios(request, response);
                    break;
                case "/usuarios/borrarUsuarios":
                    deleteUsuarios(request, response);
                    break;
                case "/usuarios/editarUsuarios":
                    showEditFormUsuarios(request, response);
                    break;
                case "/usuarios/actualizarUsuarios":
                    updateUsuarios(request, response);
                    break;
                case "/usuarios/listarUsuarios":
                    listUsuarios(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Usuarios> listUsuarios = usuariosDao.selectAll();
        request.setAttribute("listaUsuarios", listUsuarios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Usuarios/usuarios.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<EnumAccesoLista> listaAcceso = AccesoEnum.getListaAcceso();
        List<EnumTipoLista> listaTipo = TipoEnum.getListaTipo();
        request.setAttribute("accesos", listaAcceso);
        request.setAttribute("tipos", listaTipo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Usuarios/usuariosForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String carnet = request.getParameter("carnet");
        Usuarios existingUsuarios = usuariosDao.select(carnet);
        List<EnumAccesoLista> listaAcceso = AccesoEnum.getListaAcceso();
        List<EnumTipoLista> listaTipo = TipoEnum.getListaTipo();
        for (EnumTipoLista tipo:
             listaTipo) {
            System.out.println(tipo.getNombre() + " " + tipo.getId());
        }

        for (EnumAccesoLista acceso:
                listaAcceso) {
            System.out.println(acceso.getNombre() + " " + acceso.getId());
        }
        //List
        request.setAttribute("usuarios", existingUsuarios);
        request.setAttribute("accesos", listaAcceso);
        request.setAttribute("tipos", listaTipo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Usuarios/usuariosForm.jsp");
        dispatcher.forward(request, response);

    }

    private void insertUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nom_usuario = request.getParameter("nom_usuario");
        String ape_usuario = request.getParameter("ape_usuario");
        String tipo = request.getParameter("tipo");
        String telcasa = request.getParameter("telcasa");
        String celular = request.getParameter("celular");
        String estado = request.getParameter("estado");
        String email = request.getParameter("email");
        String clave = request.getParameter("clave");
        int acessosistemas = Integer.parseInt(request.getParameter("acessosistemas"));
        int esadministrador = Integer.parseInt(request.getParameter("esadministrador"));

        Usuarios newUsuarios = new Usuarios(nom_usuario, ape_usuario, tipo, telcasa, celular, email, estado, clave, acessosistemas, esadministrador);
        usuariosDao.insert(newUsuarios);
        response.sendRedirect("listarUsuarios");
    }

    private void updateUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String carnet = request.getParameter("carnet");
        String nom_usuario = request.getParameter("nom_usuario");
        String ape_usuario = request.getParameter("ape_usuario");
        String tipo = request.getParameter("tipo");
        String telcasa = request.getParameter("telcasa");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String estado = request.getParameter("estado");
        String clave = request.getParameter("clave");
        int acessosistemas = Integer.parseInt(request.getParameter("acessosistemas"));
        int esadministrador = Integer.parseInt(request.getParameter("esadministrador"));

        Usuarios newUsuarios = new Usuarios(carnet, nom_usuario, ape_usuario, tipo, telcasa,celular, email, estado, clave, acessosistemas, esadministrador);
        usuariosDao.edit(newUsuarios);
        response.sendRedirect("listarUsuarios");
    }

    private void deleteUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String carnet = request.getParameter("carnet");
        usuariosDao.delete(carnet);
        response.sendRedirect("listarUsuarios");
    }
}
