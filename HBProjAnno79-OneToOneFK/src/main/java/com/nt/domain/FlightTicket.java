package com.nt.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Anno_FlightTicket_Tab")
public class FlightTicket {
	private int ticketNo;
	private int seatNo;
	private String flightNo;
	private Date  doj;
	private String source;
	private String destination;
	private FlightPassenger passenger;
	
	@OneToOne(targetEntity=FlightPassenger.class,
			   cascade=CascadeType.ALL,
			   fetch=FetchType.LAZY)
    @JoinColumn(name="passegner_id",referencedColumnName="passengerId")			   
	public FlightPassenger getPassenger() {
		return passenger;
	}
	public void setPassenger(FlightPassenger passenger) {
		this.passenger = passenger;
	}
	@Id
	@SequenceGenerator(name="gen1",sequenceName="ticket_Seq",initialValue=1000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	
	@Column(length=4,nullable=false)
	@Type(type="int")
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="string")
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
	@Column(nullable=false)
	@Type(type="date")
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	@Column(length=10,nullable=false)
	@Type(type="string")
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="string")
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
