package clinicamedica;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lukas
 */
public class ClinicaMedica {

    private static BancoDeDados1 pessoas = new BancoDeDados1();

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            System.out.println("1 - Cadastrar um médico");
            System.out.println("2 - Cadastrar um paciente");
            System.out.println("3 - Cadastrar uma secretária");
            System.out.println("4 - Remover um médico, paciente ou secretária");
            System.out.println("5 - Listar os médicos da clínica");
            System.out.println("6 - Buscar pessoas pelo CPF");
            System.out.println("7 - Buscar um médico pelo CRM");
            System.out.println("8 - Buscar pessoas pelo nome");
            System.out.println("9 - Buscar pessoas pelo endereço");
            System.out.println("10 - Sair do sistema");
            System.out.println("Escolha a opção desejada:");
            Scanner s = new Scanner(System.in);
            int opcao = s.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarMedico();
                    break;
                case 2:
                    cadastrarPaciente();
                    break;
                case 3:
                    cadastrarSecretaria();
                    break;
                case 4:
                    removerPessoa();
                    break;
                case 5:
                    listarMedicos();
                    break;
                case 6:
                    buscarPessoasPorCpf();
                    break;
                case 7:
                    buscarMedicosPorCrm();
                    break;
                case 8:
                    buscarPessoasPorNome();
                    break;
                case 9:
                    buscarPessoasPorEndereco();
                    break;
                case 10:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

    }

    //Cadastrar um médico
    public static void cadastrarMedico() {
        Medico m = new Medico();
        m.cadastrar();
        pessoas.addPessoa(m);
    }

    // Remover a pessoa
    public static void removerPessoa() {
        System.out.println("Qual é o CPF da pessoa que deseja remover?");
        Scanner s = new Scanner(System.in);
        String cpf = s.next();
        Pessoa p = pessoas.findByCpf(cpf);
        if (p != null) {
            pessoas.removePessoa(p);
        }
    }

    //Listar médicos
    public static void listarMedicos() {
        //Retornar uma lista de todos os médicos do banco
        List<Medico> medicos = pessoas.listarAllCrm();
        for (Medico m : medicos) {
            System.out.println(m);
        }
    }

    // Cadastrar paciente
    public static void cadastrarPaciente() {
        Paciente p = new Paciente();
        p.cadastrar();
        pessoas.addPessoa(p);
        //Linkar um médico
        System.out.println("Qual o CRM do médico que irá atender?");
        Scanner s = new Scanner(System.in);
        int crm = s.nextInt();
        Medico m = pessoas.findByCrm(crm);
        if (m != null) {
            p.setMedico(m);
            m.addPaciente(p);
        }
    }

    public static void buscarPessoasPorCpf() {
        System.out.println("Qual é o CPF que quer buscar?");
        Scanner s = new Scanner(System.in);
        String cpf = s.next();
        Pessoa p = pessoas.findByCpf(cpf);
        System.out.println(p);
    }

    public static void cadastrarSecretaria() {
        Secretaria s = new Secretaria();
        s.cadastrar();
        pessoas.addPessoa(s);
    }

    public static void buscarMedicosPorCrm() {
        System.out.println("Qual é o CRM que quer buscar?");
        Scanner s = new Scanner(System.in);
        int crm = s.nextInt();
        Pessoa p = pessoas.findByCrm(crm);
        System.out.println(p);
    }

    public static void buscarPessoasPorNome() {
        System.out.println("Qual é o nome que quer buscar?");
        Scanner s = new Scanner(System.in);
        String nome = s.next();
        Pessoa p = (Pessoa) pessoas.listByNome(nome);
        System.out.println(p);
    }

    public static void buscarPessoasPorEndereco() {
        System.out.println("Informe o CEP");
        Scanner s = new Scanner(System.in);
        String cep = s.next();
        Pessoa p = (Pessoa) pessoas.listByNome(cep);
        System.out.println(p);
    }
}
