import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SistemaRecomendacao {
    // Declaração do grafo conforme exigido no enunciado
    private Map<Livro, Set<Livro>> grafo;

    public SistemaRecomendacao() {
        this.grafo = new HashMap<>();
    }

    // Adiciona o nó (Livro) no grafo
    public void adicionarLivro(Livro livro) {
        grafo.putIfAbsent(livro, new HashSet<>());
    }

    // Cria a aresta (relação) entre o livro lido e o livro recomendado
    public void adicionarRecomendacao(Livro origem, Livro recomendacao) {
        // Verifica se ambos os livros existem no grafo antes de conectar
        if (grafo.containsKey(origem) && grafo.containsKey(recomendacao)) {
            grafo.get(origem).add(recomendacao);
        } else {
            System.out.println("Erro: Ambos os livros precisam estar no sistema.");
        }
    }

    // Retorna as recomendações baseadas no livro pesquisado
    public Set<Livro> obterRecomendacoes(Livro livroLido) {
        return grafo.getOrDefault(livroLido, new HashSet<>());
    }

    // Método extra para exibir todo o grafo no terminal
    public void exibirGrafo() {
        for (Map.Entry<Livro, Set<Livro>> entry : grafo.entrySet()) {
            System.out.println("Usuários que leram '" + entry.getKey().getTitulo() + "' também recomendam:");
            for (Livro rec : entry.getValue()) {
                System.out.println("  -> " + rec.getTitulo());
            }
            System.out.println("--------------------------------------------------");
        }
    }
}