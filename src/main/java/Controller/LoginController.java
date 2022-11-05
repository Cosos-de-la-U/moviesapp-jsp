package Controller;

import DAO.LoginDAO;
import Model.Usuarios;
import Enum.TipoUsuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private LoginDAO loginDAO;

    public void init(){
        loginDAO = new LoginDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        //Get paramethers
        String carnet = request.getParameter("carnet");
        String clave = request.getParameter("clave");
        //Check if user exist
        Usuarios usuarioSession = loginDAO.logIn(carnet, clave);
        System.out.println(usuarioSession.getCarnet() + " " + usuarioSession.getNom_usuario() + " " + usuarioSession.getEsadministrador() +" " +usuarioSession.getClave());
        //Validate and redirect
        TipoUsuario usuarioTipo = loginDAO.validate(usuarioSession);
        if (!usuarioTipo.equals(TipoUsuario.ADMIN)){
            HttpSession session = request.getSession();
            session.setAttribute("usuarioSession", usuarioSession);
            response.sendRedirect("View/Admin/");
            System.out.println("Entro");
        }else {
            System.out.println("No entro");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
