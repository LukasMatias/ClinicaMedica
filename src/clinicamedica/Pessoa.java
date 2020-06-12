package clinicamedica;

import java.util.Scanner;

/**
 *
 * @author lukas
 */
public abstract class Pessoa implements Cloneable {

    private String nome;
    private String cpf;
    private Endereco endereco;

    protected Pessoa() {
    }

    protected Pessoa(String cpf) {
        this.cpf = cpf;
    }

    public abstract String atribuicoes();

    public abstract String getIdentificacao();

    public void cadastrar() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        this.nome = input.nextLine();
        System.out.print("Digite o CPF: ");
        this.cpf = input.next();
       

        Endereco e = new Endereco();
        System.out.print("Digite a rua: ");
        String rua = input.next(); input.nextLine();
        e.setRua(rua);

        System.out.print("Digite o CEP: ");
        String cep = input.next();input.nextLine();
        e.setCep(cep);

        System.out.print("Digite a cidade: ");
        String cidade = input.next();input.nextLine();
        e.setCidade(cidade);

        this.endereco = e;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pessoa) {
            Pessoa p = (Pessoa) obj;
            if (this.cpf.equals(p.cpf)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return cpf.hashCode();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

     public​ void info() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Endereço: " + this.getEndereco().getRua());
    }

    @Override
    public String toString() {
        return "nome: " + nome + "\n"
                + "CPF: " + cpf + "\n"
                + "Endereço : " + endereco;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Pessoa p = (Pessoa) super.clone();
        p.endereco = (Endereco) endereco.clone();
        return super.clone();
    }

}
