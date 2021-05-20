package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Consulta;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

@Stateful
public class ConsultaDAO<TIPO>  extends DAOGenerico<Consulta> implements Serializable  {
    public ConsultaDAO(){
        super();
        classePersistente = Consulta.class;
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("data", "Data", "="));
        listaOrdem.add(new Ordem("hora", "Hora", "="));
        listaOrdem.add(new Ordem("preconsulta", "preConsulta", "like"));
        listaOrdem.add(new Ordem("posconsulta", "posConsulta", "like"));
        listaOrdem.add(new Ordem("medico.nome", "Medico", "like"));
        listaOrdem.add(new Ordem("paciente.nome", "Paciente", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);     
    }
    @Override
    public Consulta getObjectByID(Object id) throws Exception {
        Consulta obj = em.find(Consulta.class, id);
        // uso para evitar o erro de lazy inicialization exception
        obj.getExames().size();
        obj.getReceituarios().size();
        return obj;
    }    
    
    public List<Consulta> getListaObjetosCompleta(){
        String jpql = "select distinct t from Consulta t join fetch t.Exames order by t.id";
        return em.createQuery(jpql).getResultList();
    }
    
    
    
}
