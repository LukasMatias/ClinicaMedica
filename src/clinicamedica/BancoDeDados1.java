package clinicamedica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class BancoDeDados1 {

    Set<Pessoa> pessoas = new HashSet<>();
    Map<String, Pessoa> pessoasByCpf = new HashMap<>();
    Map<Integer, Medico> medicosByCrm = new HashMap<>();
//    SortedMap<String, Pessoa> pessoasByNome = new TreeMap<>();
    SortedMap<String, List<Pessoa>> pessoasByNome = new TreeMap<>();
    Map<String, Endereco> pessoasByEndereco = new HashMap<>();

    public void addPessoa(Pessoa p) {
        if (pessoas.add(p)) {
            pessoasByCpf.put(p.getCpf(), p);
            pessoasByEndereco.put(p.getEndereco().getCep(), p.getEndereco());
            List<Pessoa> listaNome = pessoasByNome.get(p.getNome().toLowerCase());
            if (listaNome == null) {
                listaNome = new ArrayList<>();
                pessoasByNome.put(p.getNome().toLowerCase(), listaNome);
            }
            listaNome.add(p);
            if (pessoas instanceof Medico) {
                Medico medico = (Medico) p;
                medicosByCrm.put(medico.getCrm(), medico);
            }
        }
    }

    void removePessoa(Pessoa p) {
        pessoas.remove(p);
        pessoasByCpf.remove(p);
        List<Pessoa> lista = pessoasByNome.get(p.getNome().toLowerCase());
        if (lista != null) {
            lista.remove(p);
        }
    }

    Pessoa findByCpf(String cpf) {
        return pessoasByCpf.get(cpf);
    }
    
    public Endereco findByEndereco(String cep){
        return findByEndereco(cep);
    }
    
     public Medico findByCrm(int crm) {
        return medicosByCrm.get(crm);
    }

    List<Pessoa> listByNome(String nome) {
        nome = nome.toLowerCase();
        SortedMap<String, List<Pessoa>> subMap = pessoasByNome.tailMap(nome);
        List<Pessoa> lista = new ArrayList<>();
        for (Map.Entry<String, List<Pessoa>> entrada : subMap.entrySet()) {
            String nome1 = entrada.getKey();
            if (nome1.startsWith(nome1)) {
                List<Pessoa> p = entrada.getValue();
                lista.addAll(p);
            } else {
                break;
            }
        }
        return lista;
    }
  
    

    List<Medico> listarAllCrm() {
        List<Medico> medicos = new ArrayList<>();
       //medicos.addAll(medicosByCrm.values());
       for(Map.Entry<Integer, Medico> e : medicosByCrm.entrySet()){
           medicos.add(e.getValue());
       }
        return medicos;
    }

}
