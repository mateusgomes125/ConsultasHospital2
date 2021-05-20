/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ConsultaDAO;
import br.edu.ifsul.modelo.Paciente;
import br.edu.ifsul.dao.MedicoDAO;
import br.edu.ifsul.dao.ReceituarioDAO;
import br.edu.ifsul.dao.ExameDAO;
import br.edu.ifsul.modelo.Exame;
import br.edu.ifsul.dao.PacienteDAO;
import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Receituario;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "controleConsulta")
@ViewScoped
public class ControleConsulta implements Serializable{
    @EJB
    private ConsultaDAO<Consulta> dao;
    private Consulta objeto;
    
    @EJB
    private MedicoDAO<Medico> daoMedico;
    
    @EJB
    private PacienteDAO<Paciente> daoPaciente;

    @EJB
    private ReceituarioDAO<Receituario> daoReceituario;
    private Receituario receituario;
    private Boolean novoReceituario;
     
    @EJB
    private ExameDAO<Exame> daoExame;
    private Exame exame;
    private Boolean novoExame;
    
    public void novoReceituario(){
        receituario = new Receituario();
        novoReceituario = true;
    }
    public void removerReceituario(Receituario obj){
        objeto.getReceituarios().remove(obj);
        Util.mensagemInformacao("Receituario removido com sucesso!");
    }
            
    public void adicionarReceituario(){
        if(!objeto.getReceituarios().contains(receituario)){
            objeto.getReceituarios().add(receituario);
            Util.mensagemInformacao("Receituario adicionado com sucesso!");
        }else{
            Util.mensagemInformacao("Consulta já possui este Receituario!");
        }
    }
    public void alterarReceituario(int index){
        receituario = objeto.getReceituarios().get(index);
        novoReceituario = false;
    }
    public void salvarReceituario(){
        if (novoReceituario){
            objeto.adicionarReceituario(receituario);
        }
        Util.mensagemInformacao("Receituario adicionado ou alterado com sucesso!");
    }
    
    public void novoExame(){
        exame = new Exame();
        novoExame = true;
    }
    public void removerExame(Exame obj){
        objeto.getExames().remove(obj);
        Util.mensagemInformacao("Exame removido com sucesso!");
    }
            
    public void adicionarExame(){
        if(!objeto.getExames().contains(exame)){
            objeto.getExames().add(exame);
            Util.mensagemInformacao("Exame adicionado com sucesso!");
        }else{
            Util.mensagemInformacao("Consulta já possui este Exame!");
        }
    }
    public void alterarExame(int index){
        exame = objeto.getExames().get(index);
        novoExame = false;
    }
    public void salvarExame(){
        if (novoExame){
            objeto.adicionarExame(exame);
        }
        Util.mensagemInformacao("Exame adicionado ou alterado com sucesso!");
    }
    
    
    public ControleConsulta() {
    }

    public ConsultaDAO<Consulta> getDao() {
        return dao;
    }

    public void setDao(ConsultaDAO<Consulta> dao) {
        this.dao = dao;
    }

    public Consulta getObjeto() {
        return objeto;
    }

    public void setObjeto(Consulta objeto) {
        this.objeto = objeto;
    }
    
    
    public String listar(){
        return "/privado/consulta/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Consulta();
    }
    
    public void alterar(Object id){
        try {
            objeto = dao.getObjectByID(id);
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id){
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }

    public MedicoDAO<Medico> getDaoMedico() {
        return daoMedico;
    }

    public void setDaoMedico(MedicoDAO<Medico> daoMedico) {
        this.daoMedico = daoMedico;
    }

    public PacienteDAO<Paciente> getDaoPaciente() {
        return daoPaciente;
    }

    public void setDaoPaciente(PacienteDAO<Paciente> daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

    public ReceituarioDAO<Receituario> getDaoReceituario() {
        return daoReceituario;
    }

    public void setDaoReceituario(ReceituarioDAO<Receituario> daoReceituario) {
        this.daoReceituario = daoReceituario;
    }

    public Receituario getReceituario() {
        return receituario;
    }

    public void setReceituario(Receituario receituario) {
        this.receituario = receituario;
    }

    public ExameDAO<Exame> getDaoExame() {
        return daoExame;
    }

    public void setDaoExame(ExameDAO<Exame> daoExame) {
        this.daoExame = daoExame;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }
    


    
    
}
