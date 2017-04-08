/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RafaelaEmília
 */
@WebServlet(name = "NovoEquipamentoServlet", urlPatterns = {"/novo.html"})
public class NovoEquipamentoServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/novo-equipamento.jsp").forward(request, response);
     }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String serie = request.getParameter("serie");
        String local = request.getParameter("local");
        String descricao = request.getParameter("descricao");
        Integer estado = Integer.valueOf(request.getParameter("estado"));
        
        Logger.getLogger(NovoEquipamentoServlet.class.getName()).log(Level.INFO, "POST: " +serie+""+local+""+descricao+""+estado);
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/lpto-2017-1";
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            System.out.println("Conexao aberta com sucesso!");
            
            String sql="INSERT INTO equipamento (serie, local, descricao, estado) VALUES("
                    +" '"
                    + serie +"', '"
                    + local +"', '"
                    + descricao +"', "
                    + estado+")";
            
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate(sql);
            System.out.println("Equipamento Criado!");
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver indisponivel!");
            Logger.getLogger(NovoEquipamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.err.println("Problema ao acessar o banco!");
            Logger.getLogger(NovoEquipamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("lista2.html");
    }

}