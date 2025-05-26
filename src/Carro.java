public class Carro extends Veiculo {
    public Carro(String modelo, String fabricante, int ano) throws Exception {
        super(modelo, fabricante, ano, "Carro");
    }
    @Override
    public String toString() {
        return "Carro - Modelo: " + getModelo() + ", Fabricante: " + getFabricante() +
                ", Ano: " + getAnoFabricacao() + ", Status: " + getStatus();
    }
}
