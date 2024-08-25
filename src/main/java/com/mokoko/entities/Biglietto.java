package com.mokoko.entities;

import java.util.Date; 

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
	@Column(name = "COD_OPERAZIONE", length = 8, nullable = false)
	private Long id;
	
	@Column(name = "DATA_ORA", nullable = false)
	private Date dataOra;
	
	@Column(name = "TIPO_PAGAMENTO", length = 20, nullable = false)
	private String tipoPagamento;
	
	@Column(name = "QUANTITA", nullable = false)
	private Integer quantita;
	
	//Relazione unidirezionale - la classe Biglietto fa  riferimento alla classe Cliente, ma non viceversa.
	@ManyToOne
	@JoinColumn(name = "COD_CLIENTE", nullable = false)
	private Cliente cliente;
	
	//Relazione unidirezionale - la classe Biglietto fa  riferimento alla classe Replica, ma non viceversa.
	@ManyToOne
	@JoinColumn(name = "COD_REPLICA", nullable = false)
	private Replica replica;

	public Biglietto() {
		super();
	}

	public Biglietto(Date dataOra, String tipoPagamento, Integer quantita, Cliente cliente, Replica replica) {
		super();
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

	public Date getDataOra() {
		return dataOra;
	}

	public void setDataOra(Date dataOra) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Biglietto [id=");
		builder.append(id);
		builder.append(", dataOra=");
		builder.append(dataOra);
		builder.append(", tipoPagamento=");
		builder.append(tipoPagamento);
		builder.append(", quantita=");
		builder.append(quantita);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", Replica=");
		builder.append(replica);
		builder.append("]");
		return builder.toString();
	}	
}
