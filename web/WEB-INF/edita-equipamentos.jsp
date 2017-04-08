<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edita Equipamentos</title>
    </head>
    <body>
        <h1>Edita Equipamentos</h1>
        <form method="post">
            <div><input type="hidden" name="id" value="${equipamento.id}"/> Id: ${equipamento.id}</div><br>
            <div><input type="hidden" name="serie" value="${equipamento.serie}"/> Serie: ${equipamento.serie}</div><br>           
            <div><label>Local: <input type="text" name="local" value="${equipamento.local}"</label></div><br>
            <div><input type="hidden" name="descricao" value="${equipamento.descricao}"/> Descricao: ${equipamento.descricao}</div><br>
            <div><label>Estado:
            <select name="estado">
                     <option value="5">Selecione</option>
                     <option value="0"${equipamento.estado==0?"selected":""}>Novo</option>
                     <option value="1"${equipamento.estado==1?"selected":""}>Em Uso</option>
                     <option value="2"${equipamento.estado==2?"selected":""}>Danificado</option>
                     <option value="3"${equipamento.estado==3?"selected":""}>Perdido</option>
                     
                </select> 
                     
            </div><br>         
            <div><input type="submit" /></div>
        </form>
    </body>
</html>
