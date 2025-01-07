import java.util.Scanner;
public class Contato {
    String nome;
    String telefone;
    String email;
    String endereco;
    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", E-mail=: " + email + ", Endereco: " + endereco;
    }
    public void leContato(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        this.nome = scanner.nextLine();
        System.out.print("Telefone: ");
        this.telefone = scanner.nextLine();
        System.out.print("E-mail: ");
        this.email = scanner.nextLine();
        System.out.print("Endereço: ");
        this.endereco = scanner.nextLine();
    }
}