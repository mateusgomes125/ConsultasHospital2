    /*  
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteListartEspecialidade {
    
       public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultasHospital-PU");
        EntityManager em = emf.createEntityManager();
        List<Especialidade> l = em.createQuery("from Especialidade order by id").getResultList();
        for (Especialidade p : l){
            System.out.println("ID: " + p.getId()+ 
                                " Descrição: " + p.getDescricao());  
        }

        em.close();
        emf.close();
        
        
        
    }
   
}
