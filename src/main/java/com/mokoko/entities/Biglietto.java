package com.mokoko.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "biglietti")
public class Biglietto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "COD_OPERAZIONE", length = 8, nullable = false)
	private String codOperazione;
	
	@Column(name = "DATA_ORA", nullable = false)
	private LocalDateTime dataOra; 
	
	@Column(name = "TIPO_PAGAMENTO", length = 20, nullable = false)
	private String tipoPagamento;
	
	@Column(name = "QUANTITA", nullable = false)
	private Integer quantita;
	
	//Relazione unidirezionale - la classe Biglietto fa  riferimento alla classe Cliente, ma non il contrario.
	@ManyToOne
	@JoinColumn(name = "COD_CLIENTE", nullable = false)
	private Cliente cliente;
	
	//Relazione unidirezionale - la classe Biglietto fa  riferimento alla classe Replica, ma non il contrario.
	@ManyToOne
	@JoinColumn(name = "COD_REPLICA", nullable = false)
	private Replica replica;

	public Biglietto() {
		super();
	}

	public Biglietto(String codOperazione, LocalDateTime dataOra, String tipoPagamento, Integer quantita, Cliente cliente, Replica replica) {
		super();
		this.codOperazione = codOperazione;
		this.dataOra = dataOra;
		this.tipoPagamento = tipoPagamento;
		this.quantita = quantita;
		this.cliente = cliente;
		this.replica = replica;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataOra() {
		return dataOra;
	}

	public void setDataOra(LocalDateTime dataOra) {
		this.dataOra = dataOra;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Replica getReplica() {
		return replica;
	}

	public void setReplica(Replica replica) {
		this.replica = replica;
	}


	public String getCodOperazione() {
		return codOperazione;
	}

	public void setCodOperazione(String codOperazione) {
		this.codOperazione = codOperazione;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Biglietto [id=");
		builder.append(id);
		builder.append(", codOperazione=");
		builder.append(codOperazione);
		builder.append(", dataOra=");
		builder.append(dataOra);
		builder.append(", tipoPagamento=");
		builder.append(tipoPagamento);
		builder.append(", quantita=");
		builder.append(quantita);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", replica=");
		builder.append(replica);
		builder.append("]");
		return builder.toString();
	}		
}
