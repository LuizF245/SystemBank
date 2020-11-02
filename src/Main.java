public class Main {

    public static void main(String[] args) {
        ContaBanco contaBanco = new ContaBanco();

        contaBanco.abrirConta("cp", "Luiz Fernando");
        contaBanco.sacar(150.0f);
        contaBanco.depositar(500.0f);
        contaBanco.pagarMensal();

        contaBanco.estadoAtual();
    }

}
