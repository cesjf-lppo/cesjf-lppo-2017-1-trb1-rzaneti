<%-- 
    Document   : novo-equipamento
    Created on : 03/04/2017, 19:53:03
    Author     : RafaelaEmília
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Equipamento</title>
    </head>
    <body>
        <h1>Novo Equipamento</h1>
        <form method="post">
            
            <label> Serie:
                <input type="text" name="serie"/><br>
            </label><br>
            <label>Local:
                <input type="text" name="local"/><br>
            </label><br>
            <label>Descricao:   <br>              
                 <textarea cols=20 id="descricao" rows="5" name="descricao"></textarea><br>
                 
            </label><br>
           <label>Estado:                
                <select name="estado">
                     <option value="4">Selecione</option>
                     <option value="0">Novo</option>
                     <option value="1">Em uso</option>
                     <option value="2">Danificado</option>
                     <option value="3">Perdido</option>
                </select>       
            </label>
            <input type="submit"/>
        </form>
    </body>
</html>

