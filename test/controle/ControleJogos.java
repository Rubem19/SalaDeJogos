package controle;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.PlataformaDao;

@WebServlet(name = "ControleJogos", urlPatterns = {"/ControleJogos"})
public class ControleJogos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Aqui se programa na servlet
        String flag, mensagem;
        // Recebe a flag que veio do formulário
        flag = request.getParameter("flag");

        if (flag != null) {
            switch (flag) {
                case "cadastrar":
                    cadastrar(request, response);
                    break;
                case "excluir":
                    excluir(request, response);
                    break;
                case "alterar":
                    alterar(request, response);
                    break;
                case "listar":
                    listar(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp"); // Redirecionar para a página inicial ou tratamento de erro
            }
        } else {
            response.sendRedirect("index.jsp"); // Redirecionar para a página inicial ou tratamento de erro
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String c, n, d;
        c = request.getParameter("codigo");
        n = request.getParameter("nome");
        d = request.getParameter("duracao");

        // Fazer o cadastro
        Jogo jogo = new Jogo();
        jogo.setCodigo(c);
        jogo.setNome(n);
        jogo.setDuracao(d);

        // Chamar o método salvarJogo na classe PlataformaDao
        int resultado = new PlataformaDao().salvarJogo(jogo);

        if (resultado == 1) {
            mensagem = "Jogo " + n + " cadastrado com sucesso";
        } else if (resultado == 2) {
            mensagem = "Jogo " + n + " já cadastrado";
        } else {
            mensagem = "Erro ao tentar salvar o jogo";
        }

        // Empacotar a mensagem para enviar para a view
        request.setAttribute("mensagem", mensagem);

        // Especificar para onde vai a mensagem
        RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");

        // Envia a mensagem para o mensagens.jsp
        disp.forward(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String c;
        c = request.getParameter("codigo");
        // Excluir o jogo
        // Adicione a lógica de exclusão aqui
    }

    private void alterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String c;
        c = request.getParameter("codigo");
        // Alterar o jogo
        // Adicione a lógica de alteração aqui
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Listar os jogos
        // Adicione a lógica de listagem aqui
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
    }
}
