package br.com.dio.desafio.dominio;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Dev {
    private String nome;
    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Iterator<Conteudo> conteudoIterator = this.conteudosInscritos.iterator();
        if (conteudoIterator.hasNext()) {
            Conteudo conteudo = conteudoIterator.next();
            conteudosConcluidos.add(conteudo);
            conteudosInscritos.remove(conteudo);
        }
    }

    public double calcularTotalXp() {
        return conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }

    public void exibirInscritos() {
        System.out.println("📚 Conteúdos Inscritos (" + conteudosInscritos.size() + "):");
        if (conteudosInscritos.isEmpty()) {
            System.out.println("   Nenhum conteúdo inscrito.");
        } else {
            int index = 1;
            for (Conteudo conteudo : conteudosInscritos) {
                exibirConteudoDetalhado(conteudo, index++);
            }
        }
        System.out.println();
    }

    public void exibirConcluidos() {
        System.out.println("✅ Conteúdos Concluídos (" + conteudosConcluidos.size() + "):");
        if (conteudosConcluidos.isEmpty()) {
            System.out.println("   Nenhum conteúdo concluído.");
        } else {
            int index = 1;
            for (Conteudo conteudo : conteudosConcluidos) {
                exibirConteudoDetalhado(conteudo, index++);
            }
        }
        System.out.println();
    }

    public void exibirXp() {
        System.out.printf("⭐ XP Total: %.1f XP%n%n", calcularTotalXp());
    }

    private void exibirConteudoDetalhado(Conteudo conteudo, int numero) {
        System.out.printf("   %d. %s%n", numero, conteudo.getTitulo());
        System.out.printf("      📝 %s%n", conteudo.getDescricao());

        if (conteudo instanceof Curso) {
            Curso curso = (Curso) conteudo;
            System.out.printf("      ⏱️  Carga Horária: %d horas%n", curso.getCargaHoraria());
        } else if (conteudo instanceof Mentoria) {
            Mentoria mentoria = (Mentoria) conteudo;
            System.out.printf("      📅 Data: %s%n",
                    mentoria.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        System.out.println();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Set<Conteudo> getConteudosInscritos() { return conteudosInscritos; }
    public Set<Conteudo> getConteudosConcluidos() { return conteudosConcluidos; }
}
