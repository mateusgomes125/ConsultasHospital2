package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Medico;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class MedicoDAO<TIPO>  extends DAOGenerico<Medico> implements Serializable  {
    public MedicoDAO(){
        super();
        classePersistente = Medico.class;
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("id", "Id", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("crm", "Crm", "like"));
        listaOrdem.add(new Ordem("especialidade.descricao", "Especialidade", "like"));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem); 
    }
}
