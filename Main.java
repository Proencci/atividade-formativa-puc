import java.util.Set;

public class Main {
    public static void main(String[] args) {
        SistemaRecomendacao sistema = new SistemaRecomendacao();

        // 1. Criando 10 Livros diferentes
        Livro l1 = new Livro("Código Limpo", "Robert C. Martin", "Engenharia de Software");
        Livro l2 = new Livro("O Programador Pragmático", "Andrew Hunt", "Engenharia de Software");
        Livro l3 = new Livro("Arquitetura Limpa", "Robert C. Martin", "Arquitetura de Software");
        Livro l4 = new Livro("Padrões de Projeto", "Erich Gamma", "Engenharia de Software");
        Livro l5 = new Livro("Algoritmos", "Thomas H. Cormen", "Ciência da Computação");
        Livro l6 = new Livro("Estruturas de Dados", "Clifford A. Shaffer", "Ciência da Computação");
        Livro l7 = new Livro("Refatoração", "Martin Fowler", "Engenharia de Software");
        Livro l8 = new Livro("Domínio-Driven Design", "Eric Evans", "Arquitetura de Software");
        Livro l9 = new Livro("Scrum: A Arte de Fazer o Dobro do Trabalho na Metade do Tempo", "Jeff Sutherland", "Gestão Ágil");
        Livro l10 = new Livro("O Mítico Homem-Mês", "Frederick P. Brooks", "Gestão de Projetos");

        // Adicionando os livros (Nós) ao grafo
        Livro[] livros = {l1, l2, l3, l4, l5, l6, l7, l8, l9, l10};
        for (Livro livro : livros) {
            sistema.adicionarLivro(livro);
        }

        // 2. Adicionando Recomendações (Arestas) - Cada livro terá pelo menos 2 conexões
        sistema.adicionarRecomendacao(l1, l2);
        sistema.adicionarRecomendacao(l1, l7);

        sistema.adicionarRecomendacao(l2, l1);
        sistema.adicionarRecomendacao(l2, l4);

        sistema.adicionarRecomendacao(l3, l8);
        sistema.adicionarRecomendacao(l3, l4);

        sistema.adicionarRecomendacao(l4, l3);
        sistema.adicionarRecomendacao(l4, l7);

        sistema.adicionarRecomendacao(l5, l6);
        sistema.adicionarRecomendacao(l5, l1);

        sistema.adicionarRecomendacao(l6, l5);
        sistema.adicionarRecomendacao(l6, l2);

        sistema.adicionarRecomendacao(l7, l1);
        sistema.adicionarRecomendacao(l7, l4);

        sistema.adicionarRecomendacao(l8, l3);
        sistema.adicionarRecomendacao(l8, l1);

        sistema.adicionarRecomendacao(l9, l10);
        sistema.adicionarRecomendacao(l9, l2);

        sistema.adicionarRecomendacao(l10, l9);
        sistema.adicionarRecomendacao(l10, l8);

        // 3. Aplicação prática: Sistema de sugestão
        System.out.println("=== SISTEMA DE RECOMENDAÇÃO DE LIVROS ===");
        System.out.println("Se você gostou de '" + l1.getTitulo() + "', nós recomendamos:");
        Set<Livro> recomendacoes = sistema.obterRecomendacoes(l1);
        for (Livro rec : recomendacoes) {
            System.out.println("- " + rec.getTitulo() + " (" + rec.getGenero() + ")");
        }
        
        System.out.println("\n==================================================");
        System.out.println("Visualização Completa do Grafo de Recomendações:");
        sistema.exibirGrafo();
    }
}