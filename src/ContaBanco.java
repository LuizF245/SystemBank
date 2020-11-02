public class ContaBanco {

    // Atributos
    private int numConta;
    private String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    // Métodos Personalizados
    public void estadoAtual() {
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: R$" + this.getSaldo());
        System.out.println("Status: " + this.isStatus());
        pularLinha();
    }

    public void abrirConta(String tipo, String dono, int numConta) {
        this.setDono(dono);
        this.setTipo(tipo);
        this.setStatus(true);
        this.setNumConta(numConta);

        if (this.getTipo().equalsIgnoreCase("cc")) {
            this.setSaldo(50);
        } else if (this.getTipo().equalsIgnoreCase("cp")) {
            this.setSaldo(150);
        }
        pularLinha();
    }

    public void fecharConta() {

        if (this.getSaldo() < 0) {
            System.out.println("Você não consegue fechar a sua conta, pois você está como devedor em nosso banco!");
        } else if (this.getSaldo() > 0) {
            System.out.println("Você precisa sacar todo seu dinheiro para fechar a conta!");
        } else {
            this.setStatus(false);
            System.out.println("Você fechou sua conta com sucesso!");
            System.out.println("Sua conta se encontra " + this.isStatus());
        }

        pularLinha();
    }

    public void depositar(float valorDeposito) {
        if (!this.isStatus()) {
            System.out.println("Você não consegue depositar dinheiro sem ter uma conta!");
        } else {
            this.setSaldo(this.getSaldo() + valorDeposito);
            System.out.println("Você depositou em sua conta R$" + valorDeposito);
        }
        pularLinha();
    }

    public void sacar(float valorSaque) {

        if (!this.isStatus()) {
            System.out.println("Você não pode sacar dinheiro sem ter uma conta!");
        } else {
            if (this.getSaldo() == 0) {
                System.out.println("Você não possui dinheiro suficiente para sacar.");
            } else if (this.getTipo().equalsIgnoreCase("cc")) {
                    this.setSaldo(this.getSaldo() - valorSaque);
                    System.out.println("Você sacou R$" + valorSaque);
                    System.out.println("E ficou com devedor de R$" + this.getSaldo() + " para o Banco.");
            } else if (this.getSaldo() < valorSaque) {
                System.out.println("Você não pode ficar como devedor no Banco pois a sua conta é " + this.getTipo());
            } else {
                this.setSaldo(this.getSaldo() - valorSaque);
                System.out.println("Você sacou R$" + valorSaque + " e ficou com um total de R$" + this.getSaldo());
            }
        }

        pularLinha();
    }

    public void pagarMensal() {

        int valorMensalidade = 0;

        if (this.getTipo().equalsIgnoreCase("cc")) {
            valorMensalidade = 12;
        } else if (this.getTipo().equalsIgnoreCase("cp")) {
            valorMensalidade = 20;
        }

        if (!isStatus()) {
            System.out.println("Você não tem uma conta ativa!");
        } else {
            if (this.getSaldo() < 0) {
                this.setSaldo(this.getSaldo() - valorMensalidade);
                System.out.println("Você pagou a mensalidade de R$" + valorMensalidade + " e ficou com R$" + this.getSaldo() + " de Devedor pro Banco!");
            } else {
                this.setSaldo(this.getSaldo() - valorMensalidade);
                System.out.println("Foi descontado R$" + valorMensalidade + " de sua conta para pagar a Mensalidade! Seu saldo atual é R$" + this.getSaldo());
            }
        }
        pularLinha();
    }

    private void mostrarSaldo() {
        System.out.println("Seu saldo atual é de R$" + getSaldo());
    }


    // Métodos Especiais

    public ContaBanco() {
        this.setSaldo(0);
        this.setStatus(false);
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
