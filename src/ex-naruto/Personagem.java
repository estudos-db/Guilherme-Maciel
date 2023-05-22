public class Personagem {
    private String nome;
    private int idade;
    private String aldeia;
    private String[] jutsus;
    private int chakra;

    public Personagem(String nome, int idade, String aldeia, String[] jutsus, int chakra) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.jutsus = jutsus;
        this.chakra = chakra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAldeia() {
        return aldeia;
    }

    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }

    public String[] getJutsus() {
        return jutsus;
    }

    public void setJutsus(String[] jutsus) {
        this.jutsus = jutsus;
    }

    public int getChakra() {
        return chakra;
    }

    public void setChakra(int chakra) {
        this.chakra = chakra;
    }

    public void adicionarJutsu(String jutsu) {
        String[] novoJutsus = new String[jutsus.length + 1];
        for (int i = 0; i < jutsus.length; i++) {
            novoJutsus[i] = jutsus[i];
        }
        novoJutsus[jutsus.length] = jutsu;
        jutsus = novoJutsus;
    }

    public void aumentarChakra(int quantidade) {
        chakra += quantidade;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Aldeia: " + aldeia);
        System.out.print("Jutsus: ");
        for (int i = 0; i < jutsus.length; i++) {
            System.out.print(jutsus[i] + ", ");
        }
        System.out.println("\nChakra: " + chakra);
    }
}