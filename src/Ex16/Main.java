package Ex16;

import java.util.Scanner;

public class Main {

    private static Scanner tc = new Scanner(System.in);
    private static RegistroDeLivros rL;
    private static RegistroDeColega rC;

    private static void adicionaColega() {
        String nome, telefone;
        Colega c;
        System.out.println("==> Adicionar colega:\n");
        System.out.print("Nome: ");
        nome = tc.nextLine();
        System.out.print("Telefone: ");
        telefone = tc.nextLine();

        c = new Colega(nome, telefone);
        rC.addColega(c);
    }

    private static void adicionaLivro() {
        String titulo, autor;
        double valor;
        Livro l;
        System.out.println("==> Adicionar Livro:\n");
        System.out.print("Titulo: ");
        titulo = tc.nextLine();
        System.out.print("Autor: ");
        autor = tc.nextLine();
        System.out.print("Valor: ");
        valor = tc.nextDouble();

        l = new Livro(titulo, autor, valor);
        rL.addLivro(l);
    }

    private static void listarLivrosLivres() {
        System.out.println("=== Lista de livros disponiveis ===");
        System.out.println("Nr Registro\t Titulo\t Autor\t Valor" );
        for (int i = 0; i < rL.size(); i++) {
            Livro l = rL.getLivro(i);
            if(l.getDataEmprestimo()==null){
                System.out.printf ("%s\t %s\t  %s\t %s\t\n",
                        l.getCodigoDoLivro(), l.getTitulo(), l.getAutor(), l.getValor());
            }
        }
    }

    private static void listarTodosColegas() {
        System.out.println("=== Lista de Colegas ===");
        System.out.println("Cod\t Nome\t\t\t Telefone" );
        for (int i = 0; i < rC.size(); i++) {
            Colega c = rC.getColega(i);
            System.out.printf ("%s\t %s\t\t  %s\n",
                    c.getCodigoDoColega(), c.getNome(), c.getTelefone());
        }
    }

    private static void listarTodosLivros() {
        System.out.println("=== Lista de livros disponiveis ===");
        System.out.println("Cod\t Titulo\t\t\t Autor\t\t Valor\t\t Situacao\t\t Colega" );
        for (int i = 0; i < rL.size(); i++) {
            Livro l = rL.getLivro(i);
            if(l.getDataEmprestimo()==null){
                System.out.printf ("%s\t %s\t\t  %s\t\t\t %s\t\t Livro Disponivel\n",
                        l.getCodigoDoLivro(), l.getTitulo(), l.getAutor(), l.getValor());
            }
            else{
                System.out.printf ("%s\t %s\t\t  %s\t\t\t %s\t\t %s\n",
                        l.getCodigoDoLivro(), l.getTitulo(), l.getAutor(), l.getValor(), l.getColegaComLivro());
            }
        }
    }

    private static void emprestarLivro() {
        boolean flag=false;
        boolean flagColega=false;
        int cod;
        int codColega;
        System.out.print("Digite o codigo do livro a ser emprestado:");
        cod = tc.nextInt();
        tc.nextLine();
        Main.listarTodosColegas();
        System.out.println();
        System.out.print("Digite o codigo do colega a emprestar o livro:");
        codColega = tc.nextInt();
        tc.nextLine();
        for (int i = 0; i < rC.size(); i++) {
            Colega colega = rC.getColega(i);
            if(colega.getCodigoDoColega()==codColega){
                flagColega=true;
                for (int i1 = 0; i1 < rL.size(); i1++) {
                    Livro l = rL.getLivro(i1);
                    if(l.getCodigoDoLivro()==cod&&l.getDataEmprestimo()==null){
                        rL.emprestaLivro(l,colega);
                        System.out.println("livro codigo "+l.getCodigoDoLivro()+" emprestado com sucesso para o colega: " + colega.getNome() + ".");
                        System.out.println("Data de emprestimo: "+l.getDataEmprestimo());
                        flag=true;
                    }
                }
                if(flag==false){
                    System.out.println("Livro não encontrado ou já emprestado.");
                }
            }
        }
        if(flagColega==false){
            System.out.println("Colega não encontrado.");
        }


    }

    private static void devolverLivro() {
        boolean flag=false;
        int cod;
        System.out.print("Digite o codigo do livro a ser devolvido:");
        cod = tc.nextInt();
        tc.nextLine();
        for (int i = 0; i < rL.size(); i++) {
            Livro l = rL.getLivro(i);
            if(l.getCodigoDoLivro()==cod){
                l.setDataEmprestimo(null);
                flag=true;
                System.out.println("livro codigo "+l.getCodigoDoLivro()+" devolvido com sucesso.");
            }
        }
        if(flag==false){
            System.out.println("Livro não encontrado.");
        }
    }

    private static void listarLivrosAZ() {
        rL.ordenaTituloAZ();

    }

    public static void main(String[] args) {

        rL = new RegistroDeLivros();
        rC = new RegistroDeColega();

        Livro l1 = new Livro ("Programacao Java I", "Jose da Silva", 98.50);
        Livro l2 = new Livro ("Calculo II", "Marina Golvea", 150.00);
        Livro l3 = new Livro ("Eletricidade Aplicada II", "Alexandre Timbu", 60.80);
        Livro l4 = new Livro ("Microeletronica II", "Luis Amaro", 52.99);
        Livro l5 = new Livro ("Arquitetura de Processadores", "Mateus Budista", 180.00);
        rL.addLivro(l1);
        rL.addLivro(l2);
        rL.addLivro(l3);
        rL.addLivro(l4);
        rL.addLivro(l5);
        Colega c1 = new Colega ("Amarildo Silva", "41996635285");
        Colega c2 = new Colega ("Jose dos Santos", "4198574525");
        Colega c3 = new Colega ("Isabela Amaral", "41986325412");
        Colega c4 = new Colega ("Bruna de Oliveira", "41997456328");
        rC.addColega(c1);
        rC.addColega(c2);
        rC.addColega(c3);
        rC.addColega(c4);



        int op;
        do {
            System.out.println("\n==> Menu:\n");
            System.out.println("   0 - sair");
            System.out.println("   1 - adiciona livro");
            System.out.println("   2 - adiciona colega");
            System.out.println("   3 - emprestar livro");
            System.out.println("   4 - devolver livro");
            System.out.println("   5 - listar livros por ordem alfabetica");
            System.out.print("\n   Opcao: ");
            op = tc.nextInt();
            tc.nextLine(); // consumir o enter

            switch (op) {
                case 0:
                    System.out.println("Saindo..."); // System.exit(0);
                    break;
                case 1:
                    adicionaLivro();
                    break;
                case 2:
                    adicionaColega();
                    break;
                case 3:
                    listarLivrosLivres();
                    emprestarLivro();
                    break;
                case 4:
                    devolverLivro();
                    break;
                case 5:
                    listarLivrosAZ();
                    listarTodosLivros();
                    break;
                default:
                    System.out.println("Opcao invalida!\n\n");
                    break;
            }
        } while (op != 0);

    }

}