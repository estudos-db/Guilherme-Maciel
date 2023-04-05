public class Paciente extends Pessoa{

    private String convenio;

    public Paciente(){
    }

    public Paciente(String nome, int idade, String convenio) {
        super(nome, idade);
        this.convenio = convenio;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", convenio='" + convenio + '\'' +
                '}';
    }
}
