import java.util.Scanner;

public class ContaBanco {

    private int numConta;
    private String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public ContaBanco(int numConta, String tipo, String dono, float saldo, boolean status) {
        this.numConta = numConta;
        this.tipo = tipo;
        this.dono = dono;
        this.saldo = saldo;
        this.status = status;
    }

    public void abrirConta() {
        System.out.println("Seu nome é " + getDono());
        System.out.println("Você está abrindo uma " + getTipo());
        System.out.println("O número da sua conta é " + getNumConta());

        if (getTipo().equalsIgnoreCase("Conta Poupança")) {
            setSaldo(getSaldo() + 150);
            System.out.println("Você optou por abrir uma " + getTipo() + ". E por isso ganhou R$" + getSaldo() + " em sua conta!");
        } else if (getTipo().equals("Conta Corrente")) {
            setSaldo(getSaldo() + 50);
            System.out.println("Você optou por abrir uma " + getTipo() + ". E por isso ganhou R$" + getSaldo() + " em sua conta!");
        }

        setStatus(true);
        mostrarSaldo();
        System.out.println("Sua conta se encontra " + isStatus());
        pularLinha();
    }

    void fecharConta() {

        if (getSaldo() < 0) {
            System.out.println("Você não consegue fechar a sua conta, pois você está como devedor em nosso banco!");
        } else if (getSaldo() > 0) {
            System.out.println("Você precisa sacar todo seu dinheiro para fechar a conta!");
        } else {
            setStatus(false);
            System.out.println("Você fechou sua conta com sucesso!");
            System.out.println("Sua conta se encontra " + isStatus());
        }

        pularLinha();
    }

    void depositar(float valorDeposito) {
        if (status == false) {
            System.out.println("Você não consegue depositar dinheiro sem ter uma conta!");
        } else {
            setSaldo(getSaldo() + valorDeposito);
            System.out.println("Você depositou em sua conta R$" + valorDeposito);
            mostrarSaldo();
        }

        pularLinha();
    }

    void sacar(float valorSaque) {

        if (isStatus() == false) {
            System.out.println("Você não pode sacar dinheiro sem ter uma conta!");
        } else {
            if (getSaldo() == 0) {
                System.out.println("Você não possui dinheiro suficiente para sacar.");
            } else if (getTipo().equalsIgnoreCase("Conta Corrente")) {
                    setSaldo(getSaldo() - valorSaque);
                    System.out.println("Você sacou R$" + valorSaque);
                    System.out.println("E ficou com devedor de R$" + getSaldo() + " para o Banco.");
            } else if (getSaldo() < valorSaque) {
                System.out.println("Você não pode ficar como devedor no Banco pois a sua conta é " + getTipo());
                mostrarSaldo();
            } else {
                setSaldo(getSaldo() - valorSaque);
                System.out.println("Você sacou R$" + valorSaque);
                mostrarSaldo();
            }
        }

        pularLinha();
    }

    public void pagarMensal() {

        float valorMensalidade;

        if (getTipo().equalsIgnoreCase("Conta Corrente")) {
            valorMensalidade = 12;
            if (getSaldo() < 0) {
                System.out.println("Você pagou a mensalidade de R$" + valorMensalidade + " e ficou com R$" + getSaldo() + " de Devedor pro Banco!");
            } else {
                setSaldo(getSaldo() - valorMensalidade);
                System.out.println("Foi descontado R$" + valorMensalidade + " de sua conta para pagar a Mensalidade!");
            }
        } else if (getTipo().equalsIgnoreCase("Conta Poupança")) {
            valorMensalidade = 20;
            if (getSaldo() < 0) {
                System.out.println("Você pagou a mensalidade e ficou com R$" + getSaldo() + " de Devedor pro Banco!");
            } else {
                setSaldo(getSaldo() - valorMensalidade);
                System.out.println("Foi descontado R$" + valorMensalidade + " de sua conta para pagar a Mensalidade!");
            }
        }
        pularLinha();
    }

    private void mostrarSaldo() {
        System.out.println("Seu saldo atual é de R$" + getSaldo());
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {

        if (tipo.equalsIgnoreCase("cp")) {
            tipo = "Conta Poupança";
        } else if (tipo.equalsIgnoreCase("cc")) {
            tipo = "Conta Corrente";
        }

        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {

        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private void pularLinha() {
        System.out.println("");
    }
}
