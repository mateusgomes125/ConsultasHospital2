package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Receituario;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class ReceituarioDAO<TIPO>  extends DAOGenerico<Receituario> implements Serializable  {
    public ReceituarioDAO(){
        super();
        classePersistente = Receituario.class;
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("id", "Id", "="));
        listaOrdem.add(new Ordem("posologia", "Posologia", "like"));
        listaOrdem.add(new Ordem("validade", "Validade", "="));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem); 
    }
}
