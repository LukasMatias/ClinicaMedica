package clinicamedica;

/**
 *
 * @author lukas
 */
public class Paciente extends Pessoa implements Cloneable {

    private Medico medico;

    @Override
    public String atribuicoes() {
        return "Atendimento pelo(a) Dr(a). " + medico.getNome();
    }

    @Override
    public String getIdentificacao() {
        return "CPF: " + getCpf();
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

 

   

    @Override
    public void info() {
        super.info();
        System.out.println(
                "O médico responsável pelo paciente "
                + getNome() + " é " + medico.getNome()
        );
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Paciente p = (Paciente) super.clone();
        return super.clone();
    }

    @Override
    public String toString() {
        String s = super.toString()
                + "Médico: " + medico;
        return s;
    }

}
