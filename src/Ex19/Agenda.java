package Ex19;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Pessoa> pessoas;
    private Pessoa pessoa;

    public Agenda() {
    }


    public Agenda(List<Pessoa> pessoas, Pessoa pessoa) {
        this.pessoas = pessoas;
        this.pessoa = pessoa;
    }



    public void armazenaPessoa(String nome, int idade, float altura) {
        pessoa = new Pessoa(nome, idade, altura);
        pessoas.add(pessoa);
    }

    public void removePessoa(String nome) {
        for (int i = 0; i<pessoas.size(); i++) {
            if(pessoas.get(i).getNome().equals(nome)) {
                pessoas.remove(i);
            }
        }

    }

    public void removePessoaPorIdade(int idade) {
        for (int i = 0; i<pessoas.size(); i++) {
            if(pessoas.get(i).getIdade() == idade) {
                pessoas.remove(i);
            }
        }
    }

    public void buscaPessoa(String nome) {
        int posicao = 0;
        for (int i = 0; i<pessoas.size(); i++) {
            if(pessoas.get(i).getNome().equals(nome)) {
                posicao = i;
            }
        }
        System.out.println(posicao);
    }

    public void imprimePessoas() {
        for (int i = 0; i<pessoas.size(); i++) {
            System.out.println(pessoas.get(i));
        }
    }

    public void imprimePessoa(int posicao) {
        System.out.println(pessoas.get(posicao));
    }

}
