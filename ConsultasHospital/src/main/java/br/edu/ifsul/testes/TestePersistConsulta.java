package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
import br.edu.ifsul.modelo.Receituario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestePersistConsulta {
    public static void main(String[] args) throws ParseException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultasHospital-PU");
        EntityManager em = emf.createEntityManager();
        Consulta r = new Consulta();
        
        
        String strDate = "10/06/2020";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();     
        c.setTime(sdf.parse(strDate));
        r.setData(c);
        
        sdf = new SimpleDateFormat("HH:mm:ss");
        Date hora = Calendar.getInstance().getTime(); 
        String dataFormatada = sdf.format(hora);
        c = Calendar.getInstance();
        c.setTime(hora);
        r.setHora(Calendar.getInstance());
        
        
        r.setExames(em.find(Exame.class,2));
               
        r.setMedico(em.find(Medico.class,3));
        
        r.setPaciente(em.find(Paciente.class,3));
        
        r.setPreConsulta("Sangramento no nariz");
        r.setPosConsulta("Hemorragia");
        
        r.setReceituarios(em.find(Receituario.class, 2));
        
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
 
}
