<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <%
        // Declaração de variáveis
        String n, f, p, c;
        Connection conexao;
        String sql;
        PreparedStatement st;
        
        // Receber dados do formulário carrgacurso.jsp
        n = request.getParameter("nome");
        f = request.getParameter("fabricante");
        p = request.getParameter("plataforma");
        c = request.getParameter("categoria");
        
        // Conectando ao BD
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogos", "root", "admin123");
        
        // Enviar os dados alterados recebidos acima na tabela banco de dados
        sql = "UPDATE jogo SET fabricante = ?, plataforma = ?, categoria = ? WHERE nome = ?";
        st = conexao.prepareStatement(sql);
        st.setString(1, f);
        st.setString(2, p);
        st.setString(3, c);
        st.setString(4, n);
        
        st.executeUpdate(); // Executa o update
        out.print("O jogo " + n + " foi alterado com sucesso!");
    %>
</body>
</html>
