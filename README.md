# CamelCase Converter

Um programa Java simples para converter nomes em CamelCase e copiá-los automaticamente para a área de transferência.

## 🚀 Funcionalidades

- Converte textos para **CamelCase** mantendo os espaços.
- Copia automaticamente o resultado para a **área de transferência**.
- Interface interativa no **console**.

## 📌 Exemplo de Uso

**Entrada:**

```
Nome: exemplo de texto
```

**Saída no console:**

```
Convertido: Exemplo De Texto (copiado para a área de transferência!)
```

Agora, se você apertar `Ctrl + V`, o texto **"Exemplo De Texto"** será colado!

## 🛠️ Como Usar

1. Clone este repositório:
   ```sh
   git clone https://github.com/seu-usuario/camelcase-converter.git
   ```
2. Navegue até o diretório do projeto:
   ```sh
   cd camelcase-converter
   ```
3. Compile e execute o programa:
   ```sh
   javac CamelCaseConverter.java
   java CamelCaseConverter
   ```
4. Digite um nome ou frase e veja a conversão acontecer automaticamente!

## 📝 Código-Fonte Principal

```java
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
```

## 📜 Licença

Este projeto é de código aberto e está disponível sob a licença MIT.

---

💡 **Dúvidas ou sugestões?** Fique à vontade para abrir uma issue! 😉

