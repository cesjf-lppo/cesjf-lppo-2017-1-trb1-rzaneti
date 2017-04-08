/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ListaEquipamentosEstadoServlet", urlPatterns = {"/lista2.html"})
public class ListaEquipamentosEstadoServlet extends HttpServlet {
    
    /**
     *
     * @param request
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Equipamento> equipamento = new ArrayList<>();
        
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lpto-2017-1", "usuario", "senha");
            
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM equipamento WHERE estado=0");
            
            while(resultado.next()){
                Equipamento equipamentoAtual = new Equipamento();
                equipamentoAtual.setId(resultado.getLong("id"));
                equipamentoAtual.setSerie(resultado.getString("serie"));
                equipamentoAtual.setLocal(resultado.getString("local"));
                equipamentoAtual.setDescricao(resultado.getString("descricao"));
                equipamentoAtual.setEstado(resultado.getInt("estado"));
                equipamento.add(equipamentoAtual);
            }
            System.out.println(equipamento);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaEquipamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex);
        }
        
        
        request.setAttribute("equipamentos", equipamento);
                
        request.getRequestDispatcher("WEB-INF/lista-ordenada.jsp").forward(request, response);
     }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
        int filtro;
        
        if (request.getParameter("pesquisa-estado")==null) {
            filtro = -1;
        } else {
            filtro = Integer.parseInt(request.getParameter("pesquisa-estado"));
        }
        
            
        List<Equipamento> equipamentos = new ArrayList<>();
        
        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lpto-2017-1","usuario","senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado;
            if (filtro==-1) {
                resultado = operacao.executeQuery("SELECT * FROM equipamento ORDER BY local");
            } else {
                resultado = operacao.executeQuery("SELECT * FROM equipamento WHERE estado = " + filtro + " ORDER BY local");
            }
            while(resultado.next()) {
                Equipamento equipamento = new Equipamento();
                equipamento.setId(resultado.getInt("id"));
                equipamento.setSerie(resultado.getString("serie"));
                equipamento.setLocal(resultado.getString("local"));
                equipamento.setDescricao(resultado.getString("descricao"));
                equipamento.setEstado(resultado.getInt("estado"));
                equipamentos.add(equipamento);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaEquipamentosEstadoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaEquipamentosEstadoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("equipamentos", equipamentos);
        request.getRequestDispatcher("WEB-INF/lista-ordenada.jsp").forward(request,response);
        }        
        
    }
        
       
        
    }
