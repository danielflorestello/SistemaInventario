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
    
    int item, idOperacion, idMercaderia;
                
    String cliente;
    
    double total, precio, cantidad, subTotal;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        List operacion;
        int idTipo = 1;
        
        switch(accion) {
            //Compra de Mercadería----------------------------------------------------------------------
            case "mostrarCompra":
                operacion = odao.listarOperacion(idTipo);
                request.setAttribute("lista", operacion);
                request.getRequestDispatcher("consulta/consultaCompra.jsp").forward(request, response);
                break;
                
            case "agregarCliente":
                cliente = request.getParameter("cliente");
                o.setParticipante(cliente);
                break;
                
            case "Agregar":
                subTotal = 0.00;
                
                item = item+1;
                idMercaderia = Integer.parseInt(request.getParameter("mercaderia"));
                precio = Double.parseDouble(request.getParameter("precio"));
                cantidad = Double.parseDouble(request.getParameter("cantidad"));
                subTotal = precio * cantidad;
                
                o = new Operacion();
                
                o.setItem(item);
                o.setIdOperacion(idOperacion);
                o.setIdMercaderia(idMercaderia);
                
                String nombreMercaderia = mdao.nombreMercaderia(idMercaderia);
                
                o.setNombreMercaderia(nombreMercaderia);
                o.setPrecio(precio);
                o.setCantidad(cantidad);
                o.setSubTotal(subTotal);
                
                listado.add(o);
                break;
                
           case "Delete":
                int idOp = Integer.parseInt(request.getParameter("idOperacion"));
                
                for (int i = 0; i < listado.size(); i++) {
                    if (listado.get(i).getIdOperacion() == idOp) {
                        listado.remove(i);
                    }
                }
                break;
                
            case "formularioCompra":
                total = 0.00;
                
                List mercaderia = mdao.listarMercaderia();
                request.setAttribute("mercaderia", mercaderia);
                request.setAttribute("cliente", cliente);
                
                for (int i = 0; i < listado.size(); i++) {
                    total = total + listado.get(i).getSubTotal();
                }
                
                request.setAttribute("total", total);
                request.setAttribute("listado", listado);
                request.getRequestDispatcher("agregar/agregarCompra.jsp").forward(request, response);
                break;
            
            case "insertarCompra":
                String fecha = request.getParameter("Fecha");
                int idUsuario = Integer.parseInt(request.getParameter("Usuario"));
                
                o.setParticipante(cliente);
                o.setMonto(total);
                o.setFecha(fecha);
                o.setIdUsuario(idUsuario);
                o.setIdTipo(idTipo);
                odao.agregarOperacion(o);
                
                int id = Integer.parseInt(odao.idOperacion());
                
                for (int i = 0; i < listado.size(); i++) {
                    de = new DetalleOperacion();
                    de.setCantidad(listado.get(i).getCantidad());                    
                    de.setPrecio(listado.get(i).getPrecio());
                    de.setSubTotal(listado.get(i).getSubTotal());
                    de.setIdOperacion(id);
                    de.setIdMercaderia(listado.get(i).getIdMercaderia());
                    ddao.agregarDetalleOperacion(de);
                }
                
                response.sendRedirect("compraControlador?accion=mostrarCompra");
                break;
                
            case "eliminarCompra":
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
