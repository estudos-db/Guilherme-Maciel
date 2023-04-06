import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Paciente> pacientes = new ArrayList<>();
        List<Medico> medicos = new ArrayList<>();

        Paciente paciente = new Paciente();
        Medico medico = new Medico();

        Clinica clinica = new Clinica(medicos, medico, pacientes, paciente);


        Paciente paciente1 = new Paciente("Guilherme", 22, "unimed");
        Paciente paciente2 = new Paciente("Matheus", 27, "ipa");
        Paciente paciente3 = new Paciente("Bruno", 18, "porto seguro");
        Paciente paciente4 = new Paciente("Joao", 42, "bradesco");
        Paciente paciente5 = new Paciente("Anderson", 31, "unimed");
        Paciente paciente6 = new Paciente(nome: "Fulano", idade: 32, convenio: "unimed");

        Medico medico1 = new Medico("Ana", 34, 111-111-111, Especialidade.CARDIO);
        Medico medico2 = new Medico("Daniela", 39, 222-222-222, Especialidade.NEURO);
        Medico medico3 = new Medico("Paulo", 43, 333-333-333, Especialidade.FISIO);
        Medico medico4 = new Medico("Maria", 58, 444-444-444, Especialidade.CARDIO);
        Medico medico5 = new Medico("Fulana", 54, 555-555-555, Especialidade.CARDIO);

        clinica.armazenaMedico(medico1.getNome(), medico1.getIdade(), medico1.getCrm(), medico1.getEspecialidade());
        clinica.armazenaMedico(medico2.getNome(), medico2.getIdade(), medico2.getCrm(), medico2.getEspecialidade());
        clinica.armazenaMedico(medico3.getNome(), medico3.getIdade(), medico3.getCrm(), medico3.getEspecialidade());
        clinica.armazenaMedico(medico4.getNome(), medico4.getIdade(), medico4.getCrm(), medico4.getEspecialidade());

        clinica.armazenaPaciente(paciente1.getNome(), paciente1.getIdade(), paciente1.getConvenio());
        clinica.armazenaPaciente(paciente2.getNome(), paciente2.getIdade(), paciente2.getConvenio());
        clinica.armazenaPaciente(paciente3.getNome(), paciente3.getIdade(), paciente3.getConvenio());
        clinica.armazenaPaciente(paciente4.getNome(), paciente4.getIdade(), paciente4.getConvenio());
        clinica.armazenaPaciente(paciente5.getNome(), paciente5.getIdade(), paciente5.getConvenio());

        clinica.imprimeMedicos();
        System.out.println("---Buscando medico por crm");
        clinica.buscaMedicoPorCrm(111-111-111);
        System.out.println("---Buscando medico por nome");
        clinica.buscaMedicoPorNome("Paulo");
        System.out.println("---Removendo medico Maria");
        clinica.removeMedico(444-444-444);
        clinica.imprimeMedicos();
        System.out.println("---Buscando paciente por nome");
        clinica.buscaPacientePorNome("Guilherme");
        System.out.println("---Buscando pacientes por convenio");
        clinica.buscaPacientePorConvenio("unimed");

    }
}