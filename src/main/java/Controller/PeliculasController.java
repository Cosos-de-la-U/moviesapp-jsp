package Controller;

import DAO.PeliculasDAO;
import Model.Peliculas;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "peliculas", urlPatterns = {
        "/peliculas/nuevaPeliculas","/peliculas/insertarPeliculas","/peliculas/borrarPeliculas","/peliculas/editarPeliculas","/peliculas/actualizarPeliculas","/peliculas/listarPeliculas"})
public class PeliculasController extends HttpServlet {
    private PeliculasDAO peliculasDao;

    public void init() {
        peliculasDao = new PeliculasDAO();
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
                case "/peliculas/nuevaPeliculas":
                    System.out.println("Not done");
                    showNewFormPeliculas(request, response);
                    break;
                case "/peliculas/insertarPeliculas":
                    insertPeliculas(request, response);
                    break;
                case "/peliculas/borrarPeliculas":
                    deletePeliculas(request, response);
                    break;
                case "/peliculas/editarPeliculas":
                    showEditFormPeliculas(request, response);
                    break;
                case "/peliculas/actualizarPeliculas":
                    updatePeliculas(request, response);
                    break;
                case "/peliculas/listarPeliculas":
                    listPeliculas(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listPeliculas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Peliculas> listaPeliculas = peliculasDao.selectAll();
        request.setAttribute("listaPeliculas", listaPeliculas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Peliculas/peliculas.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormPeliculas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Peliculas/peliculasForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormPeliculas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idpeliculas"));
        Peliculas existingPeliculas = peliculasDao.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/View/Peliculas/peliculasForm.jsp");
        request.setAttribute("peliculas", existingPeliculas);
        dispatcher.forward(request, response);

    }

    private void insertPeliculas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nombre = request.getParameter("nombre");
        String nombreIngles = request.getParameter("nombreIngles");
        int yearp = Integer.parseInt(request.getParameter("yearp"));
        int duracion = Integer.parseInt(request.getParameter("duracion"));

        Peliculas newPeliculas = new Peliculas(nombre, nombreIngles, yearp, duracion);
        peliculasDao.insert(newPeliculas);
        response.sendRedirect("listarPeliculas");
    }

    private void updatePeliculas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int idPeliculas = Integer.parseInt(request.getParameter("idpeliculas"));
        String nombre = request.getParameter("nombre");
        String nombreIngles = request.getParameter("nombreIngles");
        int yearp = Integer.parseInt(request.getParameter("yearp"));
        int duracion = Integer.parseInt(request.getParameter("duracion"));

        Peliculas newPeliculas = new Peliculas(idPeliculas, nombre, nombreIngles, yearp, duracion);
        peliculasDao.edit(newPeliculas);
        response.sendRedirect("listarPeliculas");
    }

    private void deletePeliculas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("idpeliculas"));
        peliculasDao.delete(id);
        response.sendRedirect("listarPeliculas");
    }
}
