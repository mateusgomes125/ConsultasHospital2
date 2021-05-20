package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Paciente;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class PacienteDAO<TIPO>  extends DAOGenerico<Paciente> implements Serializable  {
    public PacienteDAO(){
        super();
        classePersistente = Paciente.class;
        // definir as ordens possíveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("nascimento", "Nascimento", "="));
        listaOrdem.add(new Ordem("telefone", "Telefone", "like"));
        listaOrdem.add(new Ordem("sexo", "Sexo", "like"));
        listaOrdem.add(new Ordem("historico", "Historico", "like"));
        listaOrdem.add(new Ordem("peso", "Peso", "="));
        listaOrdem.add(new Ordem("altura", "Altura", "="));
        // difinir a ordem inicial
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor das ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem); 
    }
}
