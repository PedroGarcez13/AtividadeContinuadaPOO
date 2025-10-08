package br.edu.cs.poo.ac.ordem.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class OrdemServico implements Serializable {
	private static final long serialVersionUID = 1L;
    private Cliente cliente;
    private PrecoBase precoBase;
    private Notebook notebook;
    private Desktop desktop;
    private LocalDateTime dataHoraAbertura;
    private int prazoEmDias;
    private double valor;

    public LocalDate getDataEstimadaEntrega() {
        if (this.dataHoraAbertura == null) {
            return null;
        }
        return this.dataHoraAbertura.toLocalDate().plusDays(this.prazoEmDias);
    }

    public String getNumero() {
        String tipoEquipamento = (notebook != null) ? notebook.getIdTipo() : desktop.getIdTipo();
        String cpfCnpj = cliente.getCpfCnpj().replaceAll("[^0-9]", "");

        if (cpfCnpj.length() == 14) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
            return tipoEquipamento + dataHoraAbertura.format(formatter) + cpfCnpj;
        } 
        else if (cpfCnpj.length() == 11) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMyyyyddHHmm");
            return dataHoraAbertura.format(formatter) + "000" + cpfCnpj;
        }

        return "INVALIDO";
    }
}