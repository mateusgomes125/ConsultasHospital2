
package br.edu.ifsul.testes;


import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestePersistirUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultasHospital-PU");
        EntityManager em = emf.createEntityManager();
        Usuario u = new Usuario();
        u.setNome("Mateus de Oliveira Gomes");
        u.setNomeUsuario("mateus");
        u.setSenha("123");
        u.setAtivo(true);
        u.setEmail("mateusgomes125.mg@gmail.com");        
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
