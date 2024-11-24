package MochilaOtimizada;

class Produto {

    private String nome;
    private Integer codigo;
    private Double peso;
    private Double valor;

    public Produto(String nome, Integer codigo, Double peso, Double valor) {
        this.nome = nome;
        this.codigo = codigo;
        this.peso = peso;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso){
        this.peso = peso;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\nNome: " + nome + "\nPeso: " + peso + " kg\n" + "Valor: " + valor + "\n";
    }


}