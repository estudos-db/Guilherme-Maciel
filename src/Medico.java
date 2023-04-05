public class Medico extends Pessoa{

    private int crm;
    private Especialidade especialidade;

    public Medico(){
    }

    public Medico(String nome, int idade, int crm, Especialidade especialidade) {
        super(nome, idade);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", crm='" + crm + '\'' +
                ", especialidade=" + especialidade +
                '}';
    }
}
