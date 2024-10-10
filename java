class Motor {
    private String nome;
    private int potencia;

    public Motor(String nome, int potencia) {
        this.nome = nome;
        this.potencia = potencia;
    }

    public String detalhes() {
        return "Motor " + nome + ", " + potencia + " HP";
    }
}

class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private int velocidade;
    private Motor motor;

    public Carro(String marca, String modelo, int ano, Motor motor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.motor = motor;
        this.velocidade = 0;
    }

    public String detalhes() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + ", Motor: " + motor.detalhes();
    }

    public void acelerar(int incremento) {
        this.velocidade += incremento;
    }

    public void frear(int decremento) {
        this.velocidade = Math.max(this.velocidade - decremento, 0);
    }

    public String statusVelocidade() {
        return "Velocidade atual: " + this.velocidade + " km/h";
    }
}

public class TesteCarro {
    public static void main(String[] args) {
        Motor motorV8 = new Motor("V8", 500);
        Motor motorV6 = new Motor("V6", 300);

        Carro carro1 = new Carro("Toyota", "Corolla", 2020, motorV8);
        Carro carro2 = new Carro("Ford", "Mustang", 2018, motorV6);

        System.out.println(carro1.detalhes());
        carro1.acelerar(20);
        System.out.println(carro1.statusVelocidade());

        System.out.println(carro2.detalhes());
        carro2.frear(5);
        System.out.println(carro2.statusVelocidade());
    }
}
class ContaBancaria {
    private double saldo;
    private String titular;

    public ContaBancaria(double saldoInicial, String titular) {
        this.saldo = saldoInicial;
        this.titular = titular;
    }

    public String saldo() {
        return "Saldo atual de " + titular + ": R$" + String.format("%.2f", saldo);
    }

    public String depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return "Depósito de R$" + String.format("%.2f", valor) + " realizado para " + titular + ".";
        }
        return "Depósito inválido.";
    }

    public String sacar(double valor) {
        if (valor > this.saldo) {
            return "Saldo insuficiente! Saldo atual: R$" + String.format("%.2f", this.saldo) + ", valor solicitado: R$" + String.format("%.2f", valor);
        }
        this.saldo -= valor;
        return "Saque de R$" + String.format("%.2f", valor) + " realizado para " + titular + ".";
    }
}

public class TesteContaBancaria {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(500, "João");
        System.out.println(conta.saldo());
        System.out.println(conta.depositar(200));
        System.out.println(conta.sacar(800));
    }
}
abstract class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public abstract String som();
}

class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public String som() {
        return nome + " diz: Au au!";
    }
}

class Gato extends Animal {
    public Gato(String nome) {
        super(nome);
    }

    @Override
    public String som() {
        return nome + " diz: Miau!";
    }
}

public class TesteAnimais {
    public static void exibirSons(Animal[] animais) {
        for (Animal animal : animais) {
            System.out.println(animal.som());
        }
    }

    public static void main(String[] args) {
        Animal[] animais = { new Cachorro("Pandora"), new Gato("Mingau"), new Cachorro("Sky") };
        exibirSons(animais);
    }
}
import java.util.ArrayList;
import java.util.List;

class Professor {
    private String nome;
    private String materia;

    public Professor(String nome, String materia) {
        this.nome = nome;
        this.materia = materia;
    }

    public String getNome() {
        return nome;
    }

    public String getMateria() {
        return materia;
    }
}

class Escola {
    private String nome;
    private List<Professor> professores;

    public Escola(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<>();
    }

    public void adicionarProfessor(Professor professor) {
        if (!professores.contains(professor)) {
            professores.add(professor);
        }
    }

    public String exibirEscola() {
        StringBuilder detalhes = new StringBuilder("Escola: " + nome + ", Professores: ");
        for (Professor professor : professores) {
            detalhes.append(professor.getNome()).append(" (").append(professor.getMateria()).append("), ");
        }
        return detalhes.toString();
    }
}

public class TesteEscola {
    public static void main(String[] args) {
        Escola escola = new Escola("Unipe");
        Professor professor = new Professor("Ricardo", "Programação");
        escola.adicionarProfessor(professor);
        System.out.println(escola.exibirEscola());
    }
}
import java.util.ArrayList;
import java.util.List;

class Empregado {
    private String nome;
    private String cargo;
    private double salario;

    public Empregado(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String detalhes() {
        return nome + ", Cargo: " + cargo + ", Salário: R$" + String.format("%.2f", salario);
    }
}

class Empresa {
    private String nome;
    private List<Empregado> empregados;

    public Empresa(String nome) {
        this.nome = nome;
        this.empregados = new ArrayList<>();
    }

    public void contratar(Empregado empregado) {
        empregados.add(empregado);
    }

    public String listarEmpregados() {
        StringBuilder detalhes = new StringBuilder("Empresa: " + nome + "\nEmpregados:\n");
        for (Empregado empregado : empregados) {
            detalhes.append(empregado.detalhes()).append("\n");
        }
        return detalhes.toString();
    }
}

public class TesteEmpresa {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("DevTech");
        Empregado empregado = new Empregado("Luan Alberto", "Desenvolvedor", 5500.00);
        empresa.contratar(empregado);
        System.out.println(empresa.listarEmpregados());
    }
}
