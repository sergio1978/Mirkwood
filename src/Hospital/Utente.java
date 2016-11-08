/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

/**
 *
 * @author UserPL022Pc14
 */
public class Utente {
    /* declarar atributos */
    String  nome,
            dataNascimeno,
            observacoes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimeno() {
        return dataNascimeno;
    }

    public void setDataNascimeno(String dataNascimeno) {
        this.dataNascimeno = dataNascimeno;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
