<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Jogos</title>
    </head>
    <body>
        <%
            String n, f, p, c;

            c = request.getParameter("categoria");
            n = request.getParameter("nome");
            f = request.getParameter("fabricante");
            p = request.getParameter("plataforma");

            try {

                // Conecta com o banco de dados
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogos", "root", "admin123");

                //Inserir os dados recebidos no cadcur.html na tabela curso do BD
                String sql = "INSERT INTO jogo VALUES(?,?,?,?)";
                PreparedStatement st = conexao.prepareStatement(sql);
                st.setString(1, n);
                st.setString(2, f);
                st.setString(3, p);
                st.setString(4, c);
                st.executeUpdate();
                // Ele executa o insert
                out.print("Jogo cadastrado com sucesso!");

            } catch (Exception ex) {
                String mensagemErro = ex.getMessage();
                //Duplicate entry 'cc' for key 'curso.PRIMARY'
                if (mensagemErro.contains("Duplicate entry")) {
                    out.print("<p style='color: blue'>Este jogo já está cadastrado<p>");
                } else {
                    out.print("Erro = " + mensagemErro);
                }
            }

        %>
    </body>
</html>
