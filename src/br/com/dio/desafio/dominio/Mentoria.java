package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Mentoria extends Conteudo {
    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data != null ? data.format(formatterBR) : "Data não informada";
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + dataFormatada +
                '}';
    }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mentoria)) return false;
        Mentoria mentoria = (Mentoria) o;
        return Objects.equals(getTitulo(), mentoria.getTitulo()) &&
                Objects.equals(getDescricao(), mentoria.getDescricao()) &&
                Objects.equals(data, mentoria.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getDescricao(), data);
    }
}
