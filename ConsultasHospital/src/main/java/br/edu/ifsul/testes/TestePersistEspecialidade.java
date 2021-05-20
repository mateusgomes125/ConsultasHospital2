package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Medico;
import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestePersistEspecialidade {
    public static void main(String[] args) throws ParseException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultasHospital-PU");
        EntityManager em = emf.createEntityManager();
        Especialidade r = new Especialidade();
        r.setDescricao("Dermatologista");
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
 
}
