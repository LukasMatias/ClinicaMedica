
package clinicamedica;

import java.util.Scanner;

/**
 *
 * @author lukas
 */
public class Secretaria extends Pessoa implements Funcionario, Cloneable {

    String ramal;
    String departamento;

    public String getRamal() {
        return ramal;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String atribuicoes() {
        return "Atendimento do departamento" + departamento;
    }

    @Override
    public void cadastrar() {
        super.cadastrar();
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o ramal: ");
        ramal = input.next();input.nextLine();

        System.out.print("Digite o departamento: ");
        departamento = input.nextLine();input.nextLine();
    }

    @Override
    public String toString() {
        String s = super.toString()
                + "\nDepartamento: " + departamento
                + "\nRamal: " + ramal;
        return s;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    

    @Override
    public String getIdentificacao() {
        return "Secretaria do CPF " + getCpf();
    }

    @Override
    public double getRemuneracao() {
        return 5.000;
    }

    @Override
    public String expediente() {
        return " Atendimento ao público das 8h00 às 18h00 no departamento de " + departamento;
    }
}
