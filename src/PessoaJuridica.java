public class PessoaJuridica extends Cliente {
    public PessoaJuridica(String nome, String cpf, String contato) throws Exception {
        super(nome, cpf, contato);
    }
    @Override
    public String toString() {
        return "Pessoa Jurídica - Nome: " + getNome() + ", CNPJ: " + getCpf() + ", Contato: " + getContato();
    }
}
