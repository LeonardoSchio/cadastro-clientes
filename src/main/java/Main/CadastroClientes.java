package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CadastroClientes {
    private List<Cliente> clientes = new ArrayList<>();

    public void adicionar(Cliente cliente) {
        clientes.add(cliente);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst(); // --> É uma operação terminal. Ela manda a esteira parar assim que encontrar o
        // primeiro elemento que passou na peneira do .filter().
    }

    public boolean removerPorId(Long id) {
        Optional<Cliente> cliente = buscarPorId(id);
        if (cliente.isPresent()) {
            clientes.remove(cliente.get());
            return true;
        }
        return false;
    }

    public boolean atualizarClientes(Long id, String nome, String email, Integer idade, double saldoCompras) {
        Optional<Cliente> clienteA = buscarPorId(id);
        if (clienteA.isPresent()) {
            Cliente cliente = clienteA.get();

            cliente.setNome(nome);
            cliente.setIdade(idade);
            cliente.setEmail(email);
            cliente.setSaldoCompras(saldoCompras);
            return true;
        }
        return false;
    }

    public List<Cliente> listarClientesVIP() {
        return clientes.stream()
                .filter(c -> c.getSaldoCompras() >= 500.0)
                .toList();
    }

    public List<Cliente> listasClientesAltoValor() {
        return clientes.stream()
                .filter(c -> c.getSaldoCompras() >= 1000)
                .toList();
    }

    public List<String> listaEmailsClientesAltoValor() {
        return clientes.stream()
                .filter(c -> c.getSaldoCompras() >= 1000)
                .map(c -> c.getEmail())
                .toList();
    }

    public List<String> listarEmailsParaMailing() {
        return clientes.stream()
                .map(c -> c.getEmail())
                .toList();
    }

    public double calcularTotalEmVendas() {
        return clientes.stream()
                .mapToDouble(c -> c.getSaldoCompras()) // --> "Pegue esse double de cada objeto e transforme minha Stream<Cliente>
                // em uma DoubleStream."
                .sum(); // --> Você pensou certinho: o dado já é um double. O .mapToDouble() serve apenas para avisar a Stream
        // que ela agora transporta números puros, desbloqueando o método .sum() para fazer o cálculo de uma vez só!
    }

    @Override
    public String toString() {
        return clientes.toString();
    }
}