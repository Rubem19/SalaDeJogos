<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listagem de Jogos</title>
    <link rel="stylesheet" href="tabela.css">
</head>
<body>
    <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogos", "root", "admin123");

            // Buscar todos os jogos da tabela jogo no BD
            String sql = "SELECT * FROM jogo";
            PreparedStatement st = conexao.prepareStatement(sql);

            ResultSet resultado = st.executeQuery(); // Executa a consulta SQL
    %>
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Fabricante</th>
                    <th>Plataforma</th>
                    <th>Categoria</th>
                    <th>Exclusão</th>
                    <th>Alteração</th>
                </tr>

                <%
                    // Exibindo os jogos
                    while (resultado.next()) {
                %>
                        <tr>
                            <td><%=resultado.getString("nome")%></td>
                            <td><%=resultado.getString("fabricante")%></td>
                            <td><%=resultado.getString("plataforma")%></td>
                            <td><%=resultado.getString("categoria")%></td>
                            <td><a href="excluirJogo.jsp?codigo=<%=resultado.getString("nome")%>">Excluir</a></td>
                            <td><a href="alterarJogo.jsp?codigo=<%=resultado.getString("nome")%>">Alterar</a></td>
                        </tr>
                <%
                    }
                %>
            </table>
    <%
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</body>
</html>
