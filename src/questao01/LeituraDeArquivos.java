package questao01;

import util.Elemento;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraDeArquivos {

    private List<Elemento> listaObj = null;

    public void lerDadosDeExecucao() {
        String arquivo = "src/exec.txt";

        try (FileReader fileReader = new FileReader(arquivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String linhaEstrutura = bufferedReader.readLine().trim();
            String[] partes = linhaEstrutura.split(";");

            String estrutura = partes[0].trim();

            if (partes.length > 1) {
                String configuracaoExtra = partes[1].trim();
            }

            EstruturaDeDados estruturaEscolhida = null;

            switch (estrutura) {
                case "LISTA":
                    System.out.println("Utilizando: LISTA ENCADEADA DUPLA");
                    estruturaEscolhida = new ListaEncadeadaDupla<>();
                    break;
                case "PILHA":
                    System.out.println("Utilizando: PILHA DINAMICA");
                    estruturaEscolhida = new PilhaDinamica<>();
                    break;
                case "FILA":
                    System.out.println("Utilizando: FILA DINAMICA");
                    estruturaEscolhida = new FilaDinamica<>();
                    break;
                case "ARVORE":
                    System.out.println("Utilizando: ARVORE BINARIA");
                    estruturaEscolhida = new ArvoreBinaria<>();
                    break;
                default:
                    System.err.println("Estrutura não reconhecida.");
                    return;
            }

            listaObj = LerDados();
            for (Elemento dado : listaObj) {
                estruturaEscolhida.inserir(dado);
            }

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] comando = linha.split(";");
                if (comando.length > 0) {
                    String funcao = comando[0].trim();

                    switch (funcao) {
                        case "INSERIR":
                            System.out.println("AÇÃO: INSERIR");
                            int pos = Integer.parseInt(comando[1].trim());
                            String nome = comando[2].trim();
                            int idade = Integer.parseInt(comando[3].trim());
                            String bairro = comando[4].trim();
                            Elemento elemento = new Elemento(nome, bairro, pos, idade);
                            estruturaEscolhida.inserir(elemento);
                            break;
                        case "REMOVER":
                            System.out.println("AÇÃO: REMOVER");
                            estruturaEscolhida.remover(Integer.parseInt(comando[1].trim()));
                            break;
                        case "IMPRIMIR":
                            System.out.println("AÇÃO: IMPRIMIR");
                            estruturaEscolhida.imprimir();
                            break;
                        case "BUSCAR":
                            System.out.println("AÇÃO: BUSCAR");
                            estruturaEscolhida.buscar(Integer.parseInt(comando[1].trim()));
                            break;
                        default:
                            System.out.println("Comando não reconhecido: " + funcao);
                            break;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public List<Elemento> LerDados() {
        List<Elemento> dados = new ArrayList<>();

        try (FileReader fileReader = new FileReader("src//entrada//DadosDeEntrada.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    int pos = Integer.parseInt(partes[0].trim());
                    String nome = partes[1].trim();
                    int idade = Integer.parseInt(partes[2].trim());
                    String bairro = partes[3].trim();
                    Elemento elemento = new Elemento(nome, bairro, pos, idade);
                    dados.add(elemento);
                } else {
                    System.err.println("Formato inválido para linha: " + linha);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return dados;
    }
}
