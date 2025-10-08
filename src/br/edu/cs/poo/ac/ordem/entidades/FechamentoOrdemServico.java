package br.edu.cs.poo.ac.ordem.entidades;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class FechamentoOrdemServico implements Serializable{
	 private static final long serialVersionUID = 1L;
    private String numeroOrdemServico;
    private LocalDate dataFechamento;
    private boolean pago;
    private String relatorioFinal;
}