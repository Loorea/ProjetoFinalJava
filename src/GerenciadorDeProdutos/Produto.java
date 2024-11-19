package GerenciadorDeProdutos;

class Produto {
    private String nome;
    private Integer codigo;
    private Double peso;

    public Produto(String nome, Integer codigo, Double peso) {
        this.nome = nome;
        this.codigo = codigo;
        this.peso = peso;
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

    @Override
    public String toString() {
        return "Código: " + codigo + "\nNome: " + nome + "\nPeso: " + peso + " kg\n";
    }
}