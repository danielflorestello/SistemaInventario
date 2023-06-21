
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
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
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
        
        HttpSession session;
        String accion = request.getParameter("accion");
        List compra, venta, mercaderia, operacion;
        int idTipo;
                
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
            
            //Ventas de Mecadería----------------------------------------------------------------------
            case "mostrarVenta":
                idTipo = 2;
                
                mercaderia = mdao.listarMercaderia();
                compra = ddao.listarDetalle(idTipo);
                
                request.setAttribute("lista1", mercaderia);
                request.setAttribute("lista", compra);
                request.getRequestDispatcher("consulta/consultaVenta.jsp").forward(request, response);
                break;
                
            case "agregarVenta":
                String Participante = request.getParameter("participante");
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
                de.setIdOperacion(idOp);
                de.setIdMercaderia(idMercaderia);
                
                ddao.agregarDetalleOperacion(de);
                break;
                
            case "eliminarVenta":
                /*int idDetalleVenta = Integer.parseInt(request.getParameter("idDetalleVenta"));
                dvdao.eliminarDetalleVenta(idDetalleVenta);*/
                break;
                
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
                
            case "Agregar":
                total = 0.00;
                item = item+1;
                cliente = request.getParameter("cliente");
                codMercaderia = Integer.parseInt(request.getParameter("mercaderia"));
                precio = Double.parseDouble(request.getParameter("precio"));
                cantidad = Double.parseDouble(request.getParameter("cantidad"));
                subTotal = precio * cantidad;
                
                Operacion op = new Operacion();
                
                op.setItem(item);
                op.setIdOperacion(idOperacion);
                op.setParticipante(cliente);
                op.setIdMercaderia(codMercaderia);
                
                String nombreMercaderia = mdao.nombreMercaderia(codMercaderia);
                
                op.setNombreMercaderia(nombreMercaderia);
                op.setPrecio(precio);
                op.setCantidad(cantidad);
                op.setSubTotal(subTotal);
                
                listado.add(op);
                
                for (int i = 0; i < listado.size(); i++) {
                    total = total + listado.get(i).getSubTotal();
                }
                
                request.setAttribute("total", total);
                request.setAttribute("listado", listado);
                request.getRequestDispatcher("Controlador?accion=formularioCompra").forward(request, response);
                break;

                
            //Ganancias
            case "mostrarGanancia":
                double totalCosto = cdao.totalCosto();
                c.setTotalCosto(totalCosto);
                
                double totalIngresos = cdao.totalIngresos();
                c.setTotalIngreso(totalIngresos);
                
                double totalGanancia = cdao.totalGanancia();
                c.setTotalGanancia(totalGanancia);
                
                request.setAttribute("calculo", c);
                request.getRequestDispatcher("ganancia.jsp").forward(request, response);
                break;
                
            default:
                session = request.getSession();
                session.invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
