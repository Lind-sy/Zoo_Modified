package zoo;

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
public class Visitor{

	private String name;
	private static List<Ticket> ticketList = new ArrayList<>();
	private static HumanCatorgorys catergory = new HumanCatorgorys();
	private static List<Voucher> voucherList = new ArrayList<>();

	public Visitor(String name, String category){
		this.name = name;
		setCatergory(category);
	};

	public Visitor(String name){
		this.name = name;
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public String getCatergory() {
		return catergory.getCategory();
	}

	public void setCatergory(String catergory) {
			this.catergory.setCategory(catergory);
	}

	public List<Voucher> getVoucherList() {
		return voucherList;
	}

	/**
	 * Method that finds user voucher based on Voucher code
	 * @param code - Voucher code
	 * @return Voucher
	 */
	public Voucher findVoucher(String code){
		for (Voucher v: voucherList) {
			if(v.getCode().equals(code)){
				return v;
			}else{
				throw new IllegalArgumentException("You don't have this voucher");
			}
		}
		return new Voucher();
	}

	public void addVoucher(Voucher voucher){
		voucherList.add(voucher);
	}

	/**
	 * Method that returns users voucher code
	 * @param index - voucher index in user voucher list
	 * @return code of voucher
	 */
	public String getVoucherCode(int index){
		if(voucherList.size()>=index) {
			return voucherList.get(index-1).getCode();
		}else{
			throw new IndexOutOfBoundsException("You don't have so much vouchers!");
		}
	}

	/**
	 * Method that adds ticket to user ticket list
	 * @param ticket
	 */
	public void addTicket(Ticket ticket) {
		ticketList.add(ticket);
	}
}
