package model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class PlataformaDao {

    // Executar as operações no Banco de dados (INSERT, UPDATE, DELETE...)
    private EntityManager manager;

    private void conectar() {
        manager = Persistence.createEntityManagerFactory("atividadeav1").createEntityManager();
    }

    public int salvarJogo(Jogo jogo) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(jogo); // Insere no Banco de dados (gera um INSERT)
            manager.getTransaction().commit();
            return 1; // Salvou corretamente
        } catch (RollbackException erro) {
            return 2; // Duplicação do código do jogo
        } catch (Exception erro) {
            return 0; // Deu outro tipo de erro
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }

    // Adicione outros métodos conforme necessário para operações com jogos
}
