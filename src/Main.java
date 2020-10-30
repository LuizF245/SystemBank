public class Main {

    public static void main(String[] args) {
        ContaBanco contaBanco = new ContaBanco(0, "", "", 0, false);

        contaBanco.setDono("Luiz Fernando");
        contaBanco.setTipo("cp");
        contaBanco.setNumConta(01);

        contaBanco.abrirConta();
        contaBanco.sacar(200.0f);
        contaBanco.depositar(500.0f);
        contaBanco.pagarMensal();
    }

}
