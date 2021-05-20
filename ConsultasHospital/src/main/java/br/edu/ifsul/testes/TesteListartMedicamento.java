    /*  
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medicamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteListartMedicamento {
    
       public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultasHospital-PU");
        EntityManager em = emf.createEntityManager();
        List<Medicamento> l = em.createQuery("from Medicamento order by id").getResultList();
        for (Medicamento p : l){
            System.out.println("ID: " + p.getId()+ 
                                " Nome: " + p.getNome());  
        }

        em.close();
        emf.close();
        
        
        
    }
   
}
