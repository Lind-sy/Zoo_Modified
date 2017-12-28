package com.vea.zoo.Zoo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Martins Buhanovskis
 * 
 * Visitor class. 
 * 
 * 		Visitor:
 * 				* gets or gives ticket
 * 				* gives ticket
 *
 */
@Entity
@Table(name = "VISITOR")
public class Visitor{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "CATEGORY")
	private Long category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Visitor(String name, Long category){
		this.name = name;
		this.category = category;
	};

	public Visitor(String name){
		this.name = name;
	};

	//	private static List<Ticket> ticketList = new ArrayList<>();
//	private static List<Voucher> voucherList = new ArrayList<>();

	//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public List<Ticket> getTicketList() {
//		return ticketList;
//	}
//
//	public String getCatergory() {
//		return catergory.getCategory();
//	}
//
//	public void setCatergory(String catergory) {
//			this.catergory.setCategory(catergory);
//	}
//
//	public List<Voucher> getVoucherList() {
//		return voucherList;
//	}
//
//	/**
//	 * Method that finds user voucher based on Voucher code
//	 * @param code - Voucher code
//	 * @return Voucher
//	 */
//	public Voucher findVoucher(String code){
//		for (Voucher v: voucherList) {
//			if(v.getCode().equals(code)){
//				return v;
//			}else{
//				throw new IllegalArgumentException("You don't have this voucher");
//			}
//		}
//		return new Voucher();
//	}
//
//	public void addVoucher(Voucher voucher){
//		voucherList.add(voucher);
//	}
//
//	/**
//	 * Method that returns users voucher code
//	 * @param index - voucher index in user voucher list
//	 * @return code of voucher
//	 */
//	public String getVoucherCode(int index){
//		if(voucherList.size()>=index) {
//			return voucherList.get(index-1).getCode();
//		}else{
//			throw new IndexOutOfBoundsException("You don't have so much vouchers!");
//		}
//	}
//
//	/**
//	 * Method that adds ticket to user ticket list
//	 * @param ticket
//	 */
//	public void addTicket(Ticket ticket) {
//		ticketList.add(ticket);
//	}
}
