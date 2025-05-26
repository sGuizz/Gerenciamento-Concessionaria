public abstract class Veiculo {
    private String modelo;
    private String fabricante;
    private int anoFabricacao;
    private String tipo;
    private String status; // "disponível" ou "vendido"

    public Veiculo(String modelo, String fabricante, int anoFabricacao, String tipo) throws Exception {
        if (anoFabricacao > 2025) {
            throw new Exception("Ano de fabricação inválido!");
        }
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
        this.status = "disponível";
    }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public int getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(int anoFabricacao) throws Exception {
        if (anoFabricacao > 2025) throw new Exception("Ano de fabricação inválido!");
        this.anoFabricacao = anoFabricacao;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public abstract String toString();
}
