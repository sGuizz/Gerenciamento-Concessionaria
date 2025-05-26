public class PessoaFisica extends Cliente {
    public PessoaFisica(String nome, String cpf, String contato) throws Exception {
        super(nome, cpf, contato);
    }
    @Override
    public String toString() {
        return "Pessoa Física - Nome: " + getNome() + ", CPF: " + getCpf() + ", Contato: " + getContato();
    }
}
