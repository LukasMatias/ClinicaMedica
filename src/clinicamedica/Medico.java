package clinicamedica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lukas
 */
public class Medico extends Pessoa implements Funcionario, Cloneable {

    private int crm;
    String especialidade;
    Collection<Paciente> pacientes = new HashSet<>();

    public Medico() {

    }

    public Medico(String cpf) {
        super(cpf);
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

   @Override
    public void cadastrar() {
        super.cadastrar();

        Scanner input = new Scanner(System.in);
        System.out.print("Digite o CRM: ");
        crm = input.nextInt();

        System.out.print("Digite a especialidade: ");
        especialidade = input.next();
        input.nextLine();
    }

    void listarMedico() {
        Pessoa medico = new Medico();
        List<Pessoa> p = new ArrayList<>();
        System.out.println(p);
     }

    @Override
    public void info() {
        super.info();
        System.out.println("CRM: " + crm);
        System.out.println("Especialidade: " + especialidade);
    }

    @Override
    public String toString() {
        String s = super.toString()
                + "\nCRM: " + crm
                + "\nEspecialidade " + especialidade;
        return s;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Medico m = (Medico) super.clone();
        m.pacientes = new HashSet<>();
        m.pacientes.addAll(pacientes);
        return m;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public double getRemuneracao() {
        return 10.000;
    }

    @Override
    public String expediente() {
        return "Horario de expediente de seg à sex das 8:00 às 17:00";
    }

    @Override
    public String atribuicoes() {
        return "Especialidade do DR." + getNome() + " na especialidade" + especialidade;
    }

    @Override
    public String getIdentificacao() {
        return "CRM: " + crm;
    }

   

    void addPaciente(Paciente p) {
       pacientes.add(p);
    }
}
