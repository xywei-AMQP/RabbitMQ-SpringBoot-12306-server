package com.xywei.domain;

public class Ticket {

	private Integer id;
	private Integer ticketCount;

	public Ticket() {
	}

	public Ticket(Integer id, Integer ticketCount) {
		this.id = id;
		this.ticketCount = ticketCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(Integer ticketCount) {
		this.ticketCount = ticketCount;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", ticketCount=" + ticketCount + "]";
	}

}
