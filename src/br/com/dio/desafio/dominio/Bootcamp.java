package br.com.dio.desafio.dominio;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final List<Conteudo> conteudos = new ArrayList<>();
    private final List<Dev> devsInscritos = new ArrayList<>();

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public List<Conteudo> getConteudos() { return conteudos; }
    public List<Dev> getDevsInscritos() { return devsInscritos; }

    public void exibirConteudos() {
        System.out.println("📚 Conteúdos do Bootcamp (" + conteudos.size() + "):");
        if (conteudos.isEmpty()) {
            System.out.println("   Nenhum conteúdo disponível.");
        } else {
            int index = 1;
            for (Conteudo conteudo : conteudos) {
                System.out.printf("   %d. %s%n", index++, conteudo.getTitulo());
                System.out.printf("      📝 %s%n", conteudo.getDescricao());

                if (conteudo instanceof Curso) {
                    Curso curso = (Curso) conteudo;
                    System.out.printf("      ⏱️ Carga Horária: %d horas%n", curso.getCargaHoraria());
                } else if (conteudo instanceof Mentoria) {
                    Mentoria mentoria = (Mentoria) conteudo;
                    System.out.printf("      📅 Data: %s%n",
                            mentoria.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
