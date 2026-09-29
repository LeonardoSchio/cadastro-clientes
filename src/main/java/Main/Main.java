package Main;

public class Main {
    public static void main(String[] args) {
        CadastroClientes cadastroClientes = new CadastroClientes();
        cadastroClientes.adicionar(new Cliente(1L, "Leonardo Schio", "leos@gmail.com", 24, 250.50));
        cadastroClientes.adicionar(new Cliente(2L , "Gustavo João Tanscheit", "gutajt@gmail.com", 24, 800.33));
        cadastroClientes.adicionar(new Cliente(3L, "Elias Eduardo Leonardi", "eliasel@gmail.com", 24, 178.90));

        cadastroClientes.atualizarClientes(1L, "João Pedro", "jp@gmail.com", 26, 1000.60);

        System.out.println(cadastroClientes);
    }
}
