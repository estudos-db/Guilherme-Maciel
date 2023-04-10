package Ex17;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private int idade;
    private List<Pessoa> pais = new ArrayList<>();

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public Pessoa(String nome, int idade, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.idade = idade;
        pais.add(pai);
        pais.add(mae);
    }

    public List<Pessoa> getPais() {
        return pais;
    }

    @Override
    public String toString() {
        if (pais.isEmpty()){
            return "Pessoa{" + "nome='" + nome + '\'' + ", idade=" + idade +'}';
        }
        return "Pessoa{" +
                "nome = '" + nome + '\'' +
                ", idade = " + idade +
                ", pai = " + pais.get(0) +
                ", mãe = " + pais.get(1) +
                '}';
    }
}
