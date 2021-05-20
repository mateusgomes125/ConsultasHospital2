package br.edu.ifsul.controle;

import br.edu.ifsul.dao.PermissaoDAO;
import br.edu.ifsul.dao.UsuarioDAO;
import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named(value = "controleUsuario")
@ViewScoped
public class ControleUsuario implements Serializable {
    
    @EJB
    private UsuarioDAO<Usuario> dao;
    private Usuario objeto;
    private Boolean novo;
    @EJB
    private PermissaoDAO<Permissao> daoPermissao;
    private Permissao permissao;
    
    public ControleUsuario(){
        
    }
    
    public void removerPermissao(Permissao obj){
        objeto.getPermissoes().remove(obj);
        Util.mensagemInformacao("Permissao removida com sucesso!");
    }
            
    public void adicionarPermissao(){
        if(!objeto.getPermissoes().contains(permissao)){
            objeto.getPermissoes().add(permissao);
            Util.mensagemInformacao("Permissao adicionada com sucesso!");
        }else{
            Util.mensagemInformacao("Usuário já possui esta permissão!");
        }
    }
    
    public void verificarUnicidadeNomeUsuario(){
        if(novo){
            try {
               if(!dao.verificaUnicidadeNomeUsuario(objeto.getNomeUsuario())){
                   Util.mensagemErro("Nome de usuário '" +objeto.getNomeUsuario() + "' já existe no banco de dados!");
                   //capturar o componente que chamou o método
                   UIComponent comp = 
                           UIComponent.getCurrentComponent(FacesContext.getCurrentInstance());
                   if (comp != null) {
                       //deixa em vermelhor apos o update
                       UIInput input = (UIInput) comp;
                       input.setValid(false);
                   }
               } 
            } catch (Exception e) {
                Util.mensagemErro("Erro do sistema:" +Util.getMensagemErro(e));
            }
        }
    }
    
    public String listar(){
        return "/privado/usuario/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Usuario();
        novo = true;
    }
    
    public void alterar(Object id){
        try {
            objeto = dao.getObjectByID(id);
            novo = false;
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
            if (novo){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public UsuarioDAO<Usuario> getDao() {
        return dao;
    }

    public void setDao(UsuarioDAO<Usuario> dao) {
        this.dao = dao;
    }

    public Usuario getObjeto() {
        return objeto;
    }

    public void setObjeto(Usuario objeto) {
        this.objeto = objeto;
    }

    /**
     * @return the novo
     */
    public Boolean getNovo() {
        return novo;
    }

    /**
     * @param novo the novo to set
     */
    public void setNovo(Boolean novo) {
        this.novo = novo;
    }

    /**
     * @return the daoPermissao
     */
    public PermissaoDAO<Permissao> getDaoPermissao() {
        return daoPermissao;
    }

    /**
     * @param daoPermissao the daoPermissao to set
     */
    public void setDaoPermissao(PermissaoDAO<Permissao> daoPermissao) {
        this.daoPermissao = daoPermissao;
    }

    /**
     * @return the permissao
     */
    public Permissao getPermissao() {
        return permissao;
    }

    /**
     * @param permissao the permissao to set
     */
    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

}
