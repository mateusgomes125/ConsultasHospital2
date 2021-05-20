
package br.edu.ifsul.utilrelatorios;


import br.edu.ifsul.modelo.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class FabricaObjetos {
        public static List<Paciente> carregaPacientes(){
            List<Paciente> lista = new ArrayList<>();
            Paciente p = new Paciente();
            p.setNome("Joao");
            Calendar c = Calendar.getInstance();
            p.setNascimento(c);
            p.setTelefone("998361127");
            p.setSexo("M");
            p.setHistorico("nada");
            p.setPeso(85.0);
            p.setAltura(1.81);

            lista.add(p);
            return lista;
    }
}
