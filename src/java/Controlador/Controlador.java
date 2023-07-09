package Controlador;

import Modelo.Calculo;
import Modelo.CalculoDAO;
import Modelo.Mercaderia;
import Modelo.MercaderiaDAO;
import Modelo.UsuarioDAO;
import Modelo.Usuarios;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    Usuarios us = new Usuarios();
    UsuarioDAO udao = new UsuarioDAO();
    
    Mercaderia me = new Mercaderia();
    MercaderiaDAO mdao = new MercaderiaDAO();
    
    Calculo c = new Calculo();
    CalculoDAO cdao = new CalculoDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session;
        String accion = request.getParameter("accion");
        List mercaderia;
                
        switch(accion) {
            //Inicio de Sesión
            case "Ingresar":
                String Usuario = request.getParameter("usuario");
                String Clave = request.getParameter("clave");

                if (Usuario.matches("[a-zA-Z1-9]*")) {

                    us = udao.validar(Usuario, Clave);
                    
                    if (Usuario.equals(us.getUsuario()) & Clave.equals(us.getClave())) {

                        if (us.getNombreRol().equals("User")) {
                            session = request.getSession();
                            session.setAttribute("usuario", us);
                            request.getRequestDispatcher("principal.jsp").forward(request, response);
                        }

                    } else {
                        request.setAttribute("mensaje", "!Usuario o Contraseña erróneo¡");
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }

                } else {
                    request.setAttribute("mensaje", "¡No se permiten caracteres especiales!");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                break;
                
            //Dashboard
            case "mostrarDashboard":
                double totalCosto = cdao.totalCosto();
                c.setTotalCosto(totalCosto);
                
                double totalIngresos = cdao.totalIngresos();
                c.setTotalIngreso(totalIngresos);
                
                double totalGanancia = cdao.totalGanancia();
                c.setTotalGanancia(totalGanancia);
                
                mercaderia = mdao.listarMercaderia();
                
                request.setAttribute("listado", mercaderia);
                request.setAttribute("calculo", c);
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                break;
                
            case "Salir":
                session = request.getSession();
                session.invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            default:
                request.getRequestDispatcher("principal.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
