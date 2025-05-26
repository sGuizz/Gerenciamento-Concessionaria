import java.time.LocalDate;

public class Venda {
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDate dataVenda;

    public Venda(Veiculo veiculo, Cliente cliente) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataVenda = LocalDate.now();
    }

    public Veiculo getVeiculo() { return veiculo; }
    public Cliente getCliente() { return cliente; }
    public LocalDate getDataVenda() { return dataVenda; }

    @Override
    public String toString() {
        return "Venda - Veículo: " + veiculo.getModelo() + " (" + veiculo.getTipo() + ")" +
                ", Comprador: " + cliente.getNome() + ", Data: " + dataVenda;
    }
}
