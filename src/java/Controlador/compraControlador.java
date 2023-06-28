
package Controlador;

import Modelo.Calculo;
import Modelo.CalculoDAO;
import Modelo.DetalleOperacion;
import Modelo.DetalleOperacionDAO;
import Modelo.Mercaderia;
import Modelo.MercaderiaDAO;
import Modelo.Operacion;
import Modelo.OperacionDAO;
import Modelo.UsuarioDAO;
import Modelo.Usuarios;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "compraControlador", urlPatterns = {"/compraControlador"})
public class compraControlador extends HttpServlet {
    
    Usuarios us = new Usuarios();
    UsuarioDAO udao = new UsuarioDAO();
    
    Mercaderia me = new Mercaderia();
    MercaderiaDAO mdao = new MercaderiaDAO();
    
    Operacion o = new Operacion();
    OperacionDAO odao = new OperacionDAO();
    
    DetalleOperacion de = new DetalleOperacion();
    DetalleOperacionDAO ddao = new DetalleOperacionDAO();
    
    Calculo c = new Calculo();
    CalculoDAO cdao = new CalculoDAO();
    
    List<Operacion> listado = new ArrayList<>();
    
    int item, idOperacion, codMercaderia;
                
    String cliente;
    
    double total, precio, cantidad, subTotal;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        List compra, mercaderia, operacion;
        int idTipo;
        
        switch(accion) {
            //Compra de Mercadería----------------------------------------------------------------------
            case "mostrarCompra":
                idTipo = 1;
                operacion = odao.listarOperacion(idTipo);
                request.setAttribute("lista", operacion);
                request.getRequestDispatcher("consulta/consultaCompra.jsp").forward(request, response);
                break;
                
            case "formularioCompra":
                mercaderia = mdao.listarMercaderia();
                request.setAttribute("mercaderia", mercaderia);
                request.getRequestDispatcher("agregar/agregarCompra.jsp").forward(request, response);
                break;
                
            case "agregarCliente":
                cliente = request.getParameter("cliente");
                o.setParticipante(cliente);
                request.setAttribute("cliente", cliente);
                request.getRequestDispatcher("compraControlador?accion=formularioCompra").forward(request, response);
                break;
                
            case "Agregar":
                total = 0.00;
                item = item+1;
                codMercaderia = Integer.parseInt(request.getParameter("mercaderia"));
                precio = Double.parseDouble(request.getParameter("precio"));
                cantidad = Double.parseDouble(request.getParameter("cantidad"));
                subTotal = precio * cantidad;
                
                o = new Operacion();
                
                o.setItem(item);
                o.setIdOperacion(idOperacion);
                o.setIdMercaderia(codMercaderia);
                
                String nombreMercaderia = mdao.nombreMercaderia(codMercaderia);
                
                o.setNombreMercaderia(nombreMercaderia);
                o.setPrecio(precio);
                o.setCantidad(cantidad);
                o.setSubTotal(subTotal);
                
                listado.add(o);
                
                for (int i = 0; i < listado.size(); i++) {
                    total = total + listado.get(i).getSubTotal();
                }
                request.setAttribute("cliente", cliente);
                request.setAttribute("total", total);
                request.setAttribute("listado", listado);
                request.getRequestDispatcher("compraControlador?accion=formularioCompra").forward(request, response);
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
