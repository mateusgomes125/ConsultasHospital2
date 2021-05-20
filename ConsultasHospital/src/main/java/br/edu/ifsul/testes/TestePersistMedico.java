package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Medico;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestePersistMedico {
    public static void main(String[] args) throws ParseException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultasHospital-PU");
        EntityManager em = emf.createEntityManager();
        Medico r = new Medico();
        r.setCrm("123456");
        
        r.setNome("DR Joao");
        
        String strDate = "05/04/1975";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();     
        c.setTime(sdf.parse(strDate));
        r.setNascimento(c);
        
        r.setTelefone("54999999999");
        
        r.setSexo("M");
        
        r.setHistorico("");
        
        r.setPeso(90.00);
        
        r.setEspecialidade(em.find(Especialidade.class, 2));
        
        r.setAltura(1.81);

        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
 
}
