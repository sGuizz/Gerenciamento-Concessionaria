public class Utilitario extends Veiculo {
    public Utilitario(String modelo, String fabricante, int ano) throws Exception {
        super(modelo, fabricante, ano, "Utilitário");
    }
    @Override
    public String toString() {
        return "Utilitário - Modelo: " + getModelo() + ", Fabricante: " + getFabricante() +
                ", Ano: " + getAnoFabricacao() + ", Status: " + getStatus();
    }
}
