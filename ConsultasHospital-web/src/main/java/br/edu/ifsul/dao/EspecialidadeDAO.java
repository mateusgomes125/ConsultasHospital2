package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Especialidade;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class EspecialidadeDAO<TIPO>  extends DAOGenerico<Especialidade> implements Serializable  {
    public EspecialidadeDAO(){
        super();
        classePersistente = Especialidade.class;
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("id", "Id", "="));
        listaOrdem.add(new Ordem("descricao", "Descricao", "like"));

        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem); 
    }
}
