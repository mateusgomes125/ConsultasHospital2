    /*  
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Paciente;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteListartPaciente {
    
       public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultasHospital-PU");
        EntityManager em = emf.createEntityManager();
        List<Paciente> l = em.createQuery("from Paciente order by id").getResultList();
        SimpleDateFormat f1 = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy, HH:mm:ss");
        for (Paciente p : l){
            System.out.println("ID: " + p.getId() + 
                                " Nome: " + p.getNome()+
                                " Altura: " + p.getAltura() + 
                                " Historico: " + p.getHistorico()+ 
                                " Nascimento:" + f1.format(p.getNascimento().getTime()) +                                 
                                " Peso: " + p.getPeso() + 
                                " Sexo: " + p.getSexo()+ 
                                " Telefone: " + p.getTelefone());
        }

        em.close();
        emf.close();
        
        
        
    }
   
}
