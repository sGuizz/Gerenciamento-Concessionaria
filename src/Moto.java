public class Moto extends Veiculo {
    public Moto(String modelo, String fabricante, int ano) throws Exception {
        super(modelo, fabricante, ano, "Moto");
    }
    @Override
    public String toString() {
        return "Moto - Modelo: " + getModelo() + ", Fabricante: " + getFabricante() +
                ", Ano: " + getAnoFabricacao() + ", Status: " + getStatus();
    }
}
