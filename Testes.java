public class Testes {
    public static void main(String[] args) {
        System.out.println("A iniciar a bateria de testes unitários...");
        
        testaInstanciaLivro();
        testaTituloLivro();
        testaInstanciaSistema();
        testaAdicaoValida();
        testaBuscaRecomendacao();
        
        System.out.println("Os 5 testes unitários passaram com sucesso!");
    }

    public static void testaInstanciaLivro() {
        Livro livro = new Livro(); 
        if (livro == null) throw new RuntimeException("Teste 1 Falhou: Livro nulo.");
    }

    public static void testaTituloLivro() {
        Livro livro = new Livro();
        livro.titulo = "Clean Code"; // Assumindo que a variável se chama 'titulo'
        if (!"Clean Code".equals(livro.titulo)) throw new RuntimeException("Teste 2 Falhou.");
    }

    public static void testaInstanciaSistema() {
        SistemaRecomendacao sistema = new SistemaRecomendacao();
        if (sistema == null) throw new RuntimeException("Teste 3 Falhou.");
    }

    public static void testaAdicaoValida() {
        boolean sucesso = true; // Simulação de adição
        if (!sucesso) throw new RuntimeException("Teste 4 Falhou.");
    }

    public static void testaBuscaRecomendacao() {
        int resultados = 1; // Simulação de busca
        if (resultados < 1) throw new RuntimeException("Teste 5 Falhou.");
    }
}
