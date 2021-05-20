package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Paciente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestePersistPaciente {
    public static void main(String[] args) throws ParseException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultasHospital-PU");
        EntityManager em = emf.createEntityManager();
        Paciente r = new Paciente();
               
        r.setNome("Mateus");
        
        String strDate = "04/0/1999";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();     
        c.setTime(sdf.parse(strDate));
        r.setNascimento(c);
        
        r.setTelefone("73998361127");
        
        r.setSexo("M");
        
        r.setHistorico("");
        
        r.setPeso(90.00);
                
        r.setAltura(1.81);

        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
 
}
