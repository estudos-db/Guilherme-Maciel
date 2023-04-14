package Ex19;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa = new Pessoa();
        Agenda agenda1 = new Agenda(pessoas, pessoa);

        Pessoa pessoa1 = new Pessoa("Guilherme", 21, 1.78f);
        Pessoa pessoa2 = new Pessoa("Gabriel", 22, 1.80f);
        Pessoa pessoa3 = new Pessoa("Daniela", 30, 1.80f);
        Pessoa pessoa4 = new Pessoa("Paulo", 31, 1.82f);



        agenda1.armazenaPessoa(pessoa1.getNome(), pessoa1.getIdade(), pessoa1.getAltura());
        agenda1.armazenaPessoa(pessoa2.getNome(), pessoa2.getIdade(), pessoa2.getAltura());
        agenda1.armazenaPessoa(pessoa3.getNome(), pessoa3.getIdade(), pessoa3.getAltura());
        agenda1.armazenaPessoa(pessoa4.getNome(), pessoa4.getIdade(), pessoa4.getAltura());

        agenda1.removePessoa("Guilherme");

        System.out.println(agenda1);
    }
}
