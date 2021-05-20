package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "medico")
public class Medico extends Paciente implements Serializable{
    
    @NotBlank(message = "O crm não pode ser em branco")
    @Length(max = 50, message = "o crm ter mais que {max} caracteres")
    @Column(name = "crm", nullable = false, length = 50)
    private String crm;
    
      
//    @ManyToOne
//    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_medico_especialidade"))
    
    private Especialidade especialidade;

    public Medico() {
    }
        
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.crm);
        hash = 37 * hash + Objects.hashCode(this.especialidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.crm, other.crm)) {
            return false;
        }
        if (!Objects.equals(this.especialidade, other.especialidade)) {
            return false;
        }
        return true;
    }

    
    

}
