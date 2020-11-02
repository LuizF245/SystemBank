public class Main {

    public static void main(String[] args) {
        ContaBanco p1 = new ContaBanco();
        ContaBanco p2 = new ContaBanco();

        p1.abrirConta("cp", "Luiz Fernando", 123);
        p1.sacar(150.0f);
        p1.depositar(500.0f);
        p1.pagarMensal();
        p1.estadoAtual();

        p2.abrirConta("cc", "Gabriel Vinhais", 321);
        p2.depositar(1800.0f);
        p2.sacar(6000.f);
        p2.pagarMensal();
        p2.estadoAtual();
    }

}
