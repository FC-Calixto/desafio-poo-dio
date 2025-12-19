import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JS");
        curso2.setDescricao("Descrição curso JS");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição mentoria Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        System.out.println();
        bootcamp.exibirConteudos();

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);

        System.out.println("=== PROGRESSO DA " + devCamila.getNome().toUpperCase() + " ===");
        devCamila.exibirInscritos();

        devCamila.progredir();
        devCamila.progredir();

        System.out.println("➡️  Após 2 progressos:");
        devCamila.exibirInscritos();
        devCamila.exibirConcluidos();
        devCamila.exibirXp();

        System.out.println("\n=== PROGRESSO DO JOÃO ===");
        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        devJoao.exibirInscritos();

        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

        System.out.println("➡️  Após 3 progressos:");
        devJoao.exibirInscritos();
        devJoao.exibirConcluidos();
        devJoao.exibirXp();
    }
}

