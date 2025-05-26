public abstract class Cliente {
    private String nome;
    private String cpf;
    private String contato;

    public Cliente(String nome, String cpf, String contato) throws Exception {
        if (!cpf.matches("\\d{11}")) {
            throw new Exception("CPF inválido! Deve conter 11 dígitos numéricos.");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) throws Exception {
        if (!cpf.matches("\\d{11}")) {
            throw new Exception("CPF inválido!");
        }
        this.cpf = cpf;
    }

    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }

    public abstract String toString();
}
