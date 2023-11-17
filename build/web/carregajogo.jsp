<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Dados dos jogos</title>
</head>
<body>
    <%
        // Declaração de variáveis
        String n;
        Connection conexao;
        String sql;
        PreparedStatement st;

        try {
            // Receber o código do jogo digitado no form altcur.html
            n = request.getParameter("nome");

            // Conectar com o banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogos", "root", "admin123");

            // Buscar o jogo na tabela do BD
            sql = "SELECT * FROM jogo WHERE nome = ?";
            st = conexao.prepareStatement(sql);
            st.setString(1, n);
            ResultSet resultado = st.executeQuery();// Executa o select

            if (resultado.next()) {
                // Carregar os dados do jogo em um formulário HTML
    %>
    <form method="post" action="altcur.jsp">
        <p>
            <label for="nom">Nome:*</label>
            <input readonly id="nom" type="text" name="nome" size="50" maxlength="50" required value="<%= resultado.getString("nome")%>">
        </p>
        <p>
            <label for="fab">Fabricante:*</label>
            <input id="fab" type="text" name="fabricante" size="50" maxlength="50" required value="<%= resultado.getString("fabricante")%>">
        </p>
        <p>
            <label for="plt">Plataforma:*</label>
            <input id="plt" type="text" name="plataforma" size="50" maxlength="50" value="<%= resultado.getString("plataforma")%>">
        </p>
        <p>
            <label for="cat">Categoria:*</label>
            <input id="cat" type="text" name="categoria" size="50" maxlength="50" value="<%= resultado.getString("categoria")%>">
        </p>
        <p>
            <input type="submit" value="Salvar Alterações">
        </p>
    </form>
    <%
            } else {
                out.print("Este jogo " + n + " não está cadastrado.");
            }
        } catch (SQLException e) {
            out.print("Entre em contato com o suporte e informe o código de erro: " + e.getErrorCode());
        }
    %>
</body>
</html>
