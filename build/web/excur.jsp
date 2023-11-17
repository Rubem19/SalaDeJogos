<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Exclusão de jogos</title>
</head>
<body>
    <%
        // Declaração de variáveis
        String n;
        Connection conexao;
        String driver, caminhoBD, user, pass, sql;

        // Receber o código digitado no form excur.html
        n = request.getParameter("nome");

        try {
            // Conectar com o banco de dados
            driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            caminhoBD = "jdbc:mysql://localhost:3306/jogos";
            user = "root";
            pass = "admin123";
            sql = "DELETE FROM jogo WHERE nome = ?";
            conexao = DriverManager.getConnection(caminhoBD, user, pass);

            // Excluir o jogo de código informado
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, n); // Completa o delete no lugar do "?"
            int resultado = st.executeUpdate(); // Executa o comando "delete", que é a query que definimos acima.

            if (resultado == 1) {
                // Mostra a mensagem de confirmação de exclusão
                out.print("O jogo " + n + " foi deletado com sucesso!");
            } else {
                // Mostra a mensagem de confirmação de exclusão
                out.print("O jogo " + n + " não está cadastrado!");
            }

        } catch (SQLException e) {
            out.print("Entre em contato com o suporte e informe o erro " + e.getErrorCode());
        }
    %>
</body>
</html>
