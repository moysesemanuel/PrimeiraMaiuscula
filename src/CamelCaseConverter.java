import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class CamelCaseConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CamelCaseConverter converter = new CamelCaseConverter();

        System.out.println("Digite um nome para converter (ou 'sair' para encerrar):");

        while (true) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando...");
                break;
            }

            String convertido = converter.converter(nome);
            copiarParaAreaDeTransferencia(convertido);
            System.out.println("Convertido: " + convertido + " (copiado para a área de transferência!)");
        }

        scanner.close();
    }

    public String converter(String nome) {
        if (nome == null || nome.isEmpty()) {
            return "";
        }

        char[] palavras = nome.toCharArray();

        for (int i = 0; i < palavras.length; i++) {
            if (Character.isAlphabetic(palavras[i])) {
                palavras[i] = Character.toLowerCase(palavras[i]);
            }

            if (i > 0 && Character.isWhitespace(palavras[i - 1]) && Character.isAlphabetic(palavras[i])) {
                palavras[i] = Character.toUpperCase(palavras[i]);
            }
        }

        palavras[0] = Character.toUpperCase(palavras[0]);
        return new String(palavras);
    }

    public static void copiarParaAreaDeTransferencia(String texto) {
        StringSelection selecao = new StringSelection(texto);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selecao, null);
    }
}
