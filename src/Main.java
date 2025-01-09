import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Contato> agenda = new ArrayList<>();
        String opcMenu = new String();
        Scanner input = new Scanner (System. in);
        do {
            // lista as opções do menu
            System. out.println("=============================================");
            System. out.println(" MENU DA APLICAÇÃO ");
            System. out.println("=============================================");
            System. out.println("[1] Novo contato");
            System. out.println("[2] Editar contato salvo");
            System. out.println("[3] Apagar contato");
            System. out.println("[4] Listar todos contatos");
            System. out.println("[5] Salvar todos contatos em arquivo");
            System. out.println("[6] Ler todos contatos de arquivo");
            System. out.println("[S] Sair do programa");
            System. out.println("=============================================");
            System. out.print("Digite sua opção: ");

            // lê como string a entrada do usuário
            opcMenu = input.next().toUpperCase();

            // Se seleciona Sair, finaliza aplicação
            if (opcMenu.charAt(0) == 'S')
                System. exit(0);

// verifica demais opções
            switch(opcMenu.charAt(0) - ((int) '0')) {
                case 1:
                    Contato contato = new Contato();
                    contato.leContato();
                    agenda.add(contato);
                    break;
                case 2:
                    System.out.print("Digite o índice do contato para editar (0 a " + (agenda.size() - 1) + "): ");
                    int indice = input.nextInt();
                    if (indice >= 0 && indice < agenda.size()) {
                        Contato contatoEditado = new Contato();
                        contatoEditado.leContato();
                        agenda.set(indice, contatoEditado);
                        System.out.println("Contato atualizado com sucesso!");
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;
                case 3:
                    System.out.print("Digite o índice do contato para apagar (0 a " + (agenda.size() - 1) + "): ");
                    int indApagar = input.nextInt();
                    if (indApagar >= 0 && indApagar < agenda.size()) {
                        agenda.remove(indApagar);
                        System.out.println("Contato removido com sucesso!");
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;
                case 4:
                    for (Contato c: agenda){
                        System.out.println("..........................");
                        System.out.println(c);
                        System.out.println("..........................");
                    }
                    break;
                case 5:
                    try {
                        exportarContatos(agenda);
                    }catch (Exception e){
                        //
                    }
                    break;
                case 6:
                    agenda = importarContatos();
                    break;
                default:
                    System. out.println("Seleção inválida [" + (opcMenu.charAt(0) - ((int) '0'))+"].Informe uma seleção válida!");
            }
        } while (true);
    }

    public static void exportarContatos(ArrayList<Contato> agenda)  throws IOException {
        FileWriter arq = new FileWriter("c:\\temp\\dados.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        int i;
        for (i=0; i<agenda.size(); i++) {
            gravarArq.println(agenda.get(i).nome + ", " + agenda.get(i).telefone + ", " + agenda.get(i).endereco + ", " + agenda.get(i).email);
        }
        gravarArq.close();
    }

    public static ArrayList<Contato> importarContatos() {
        ArrayList<Contato> agendaLida = new ArrayList<>();
        double x, y;
        String[] campos;

        try {
            FileReader arq = new FileReader("c:\\temp\\dados.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine(); 

            while (linha != null) {
                Contato contato = new Contato();

                campos = linha.split(", ");

                contato.nome = campos[0];
                contato.telefone =  campos[1];
                contato.endereco = campos[2];
                contato.email = campos[3];

                agendaLida.add(contato);
                linha = lerArq.readLine();// lê da segunda até a última linha
            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Erro na abertura do arquivo: "+ e.getMessage());
        }
        return agendaLida;
    }

}
