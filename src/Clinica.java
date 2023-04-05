import java.util.List;

public class Clinica {

    private List<Medico> medicos;
    private Medico medico;
    private List<Paciente> pacientes;
    private Paciente paciente;


    public Clinica(List<Medico> medicos, Medico medico, List<Paciente> pacientes, Paciente paciente) {
        this.medicos = medicos;
        this.medico = medico;
        this.pacientes = pacientes;
        this.paciente = paciente;
    }

    public void armazenaMedico(String nome, int idade, int crm, Especialidade especialidade){
        medico = new Medico(nome, idade, crm, especialidade);
        medicos.add(medico);
    }

    public void removeMedico(int crm){
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getCrm() == crm){
                medicos.remove(i);
            }
        }
    }

    public void buscaMedicoPorNome(String nome){
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getNome().equals(nome)){
                System.out.println(medicos.get(i));
            }
        }
    }

    public void buscaMedicoPorCrm(int crm){
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getCrm() == crm){
                System.out.println(medicos.get(i));

            }
        }
    }

    public void imprimeMedicos(){
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(medicos.get(i));
        }
    }

    public void armazenaPaciente(String nome, int idade, String convenio){
        paciente = new Paciente(nome, idade, convenio);
        pacientes.add(paciente);
    }

    public void buscaPacientePorNome(String nome){
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getNome().equals(nome)){
                System.out.println(pacientes.get(i));
            }
        }
    }

    public void buscaPacientePorConvenio(String convenio){
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getConvenio().equals(convenio)){
                System.out.println(pacientes.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "Clinica{" +
                "medicos=" + medicos +
                ", medico=" + medico +
                ", pacientes=" + pacientes +
                ", paciente=" + paciente +
                '}';
    }
}
