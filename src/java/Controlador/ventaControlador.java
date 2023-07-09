package Controlador;

import Modelo.DetalleOperacion;
import Modelo.DetalleOperacionDAO;
import Modelo.Mercaderia;
import Modelo.MercaderiaDAO;
import Modelo.Operacion;
import Modelo.OperacionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ventaControlador", urlPatterns = {"/ventaControlador"})
public class ventaControlador extends HttpServlet {
    
    Mercaderia me = new Mercaderia();
    MercaderiaDAO mdao = new MercaderiaDAO();
    
    Operacion o = new Operacion();
    OperacionDAO odao = new OperacionDAO();
    
    DetalleOperacion de = new DetalleOperacion();
    DetalleOperacionDAO ddao = new DetalleOperacionDAO();
    
    int idOperacion;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        int idTipo = 2;
        
        switch(accion){
            //Ventas de Mecadería----------------------------------------------------------------------
            case "mostrarVenta": 
                List mercaderia = mdao.listarMercaderia();
                List compra = ddao.listarDetalle(idTipo);
                
                request.setAttribute("lista1", mercaderia);
                request.setAttribute("lista", compra);
                request.getRequestDispatcher("consulta/consultaVenta.jsp").forward(request, response);
                break;
                
            case "agregarVenta":
                String Participante = request.getParameter("Participante");
                int idMercaderia = Integer.parseInt(request.getParameter("idMercaderia"));
                double Cantidad = Double.parseDouble(request.getParameter("Cantidad"));
                double Precio = Double.parseDouble(request.getParameter("Precio"));
                double Monto = Double.parseDouble(request.getParameter("Monto"));
                String Fecha = request.getParameter("Fecha");
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                idTipo = Integer.parseInt(request.getParameter("idTipo"));
                
                o.setParticipante(Participante);
                o.setMonto(Monto);
                o.setFecha(Fecha);
                o.setIdUsuario(idUsuario);
                o.setIdTipo(idTipo);
                odao.agregarOperacion(o);
                
                int idOp = Integer.parseInt(odao.idOperacion());
                
                de.setCantidad(Cantidad);
                de.setPrecio(Precio);
                de.setSubTotal(Monto);
                de.setIdOperacion(idOp);
                de.setIdMercaderia(idMercaderia);
                
                ddao.agregarDetalleOperacion(de);
                break;
                
            case "eliminarVenta":
                idOperacion = Integer.parseInt(request.getParameter("idOperacion"));
                odao.eliminarOperacion(idOperacion);
                ddao.eliminarDetalle(idOperacion);
                break;
                
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
