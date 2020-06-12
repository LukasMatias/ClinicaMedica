package clinicamedica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author lukas
 */
public class BancoDeDados {

    private Set<Pessoa> pessoas = new HashSet<>();
    private SortedMap<String, Pessoa> pessoasByNome = new TreeMap<>();
    private Map<String, Pessoa> pessoasByCpf = new HashMap<>();
    private Map<Integer, Medico> medicosByCrm = new HashMap<>();

    public void addPessoa(Pessoa p) {
        if (pessoas.add(p)) {
            pessoasByNome.put(p.getNome(), p);
            pessoasByCpf.put(p.getCpf(), p);
            if (pessoas instanceof Medico) {
                Medico medico = (Medico) p;
                medicosByCrm.put(medico.getCrm(), medico);
            }
        }
    }

    public void remove(Pessoa p) {
        if (pessoas.contains(p)) {
            pessoas.remove(p);
            pessoasByCpf.remove(p.getCpf());
            pessoasByNome.remove(p.getNome());
            if (pessoas instanceof Medico) {
                Medico medico = (Medico) p;
                medicosByCrm.remove(medico.getCrm());
            }
        }
    }

    public Pessoa findByNome(String nome) {
        return pessoasByNome.get(nome);
    }

    public Pessoa findByCpf(String cpf) {
        return pessoasByCpf.get(cpf);
    }

    public Medico findByCrm(int crm) {
        return medicosByCrm.get(crm);
    }
    
    public List<Pessoa> listByNome (String nomeInicial){
        Map<String, Pessoa> subMap = pessoasByNome.tailMap(nomeInicial);
        List<Pessoa> lista = new ArrayList<>();
        for(String nome: subMap.keySet()){
            if(nome.startsWith(nomeInicial)){
                lista.add(subMap.get(nome));
            } else break;
        }
        return lista;
    }
}
