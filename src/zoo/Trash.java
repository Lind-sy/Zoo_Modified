package zoo;

public class Trash {

    //	/*
//	public ArrayList<Ticket> ticketsOutput() {
//		for(Ticket ticket : tickets) {
//
//			System.out.println("Ticket: \n\tdate: "+ticket.date
//			+"\n\tprice: "+dec.format(ticket.price)
//			+"\n\tzone type: "+ticket.date
//			+"\n\tdiscount: "+dec.format(ticket.discount)
//			+"\n\tstatus: "+ticket.humanStatus
//			+"\n\tcode: "+ticket.code
//			+"\n\nTotal: "+dec.format(ticket.total));
//		}
//		return tickets;
//	}
//	*/
//
//
//	/**
//	 * prints out specific ticket
//	 *
//	 * @param type
//	 * @param date
//	 */
//	public void ticketOutput(String type,String date) {
//
//		for(Ticket ticket : tickets) {
//			if(ticket.getType().equals(type) & ticket.getDate().equals(date) ) {
//			System.out.println("Ticket: \n\tdate: "+ticket.date
//			+"\n\tprice: "+dec.format(ticket.price)
//			+"\n\tzone type: "+ticket.zoneType
//			+"\n\tdiscount: "+dec.format(ticket.discount)
//			+"\n\tstatus: "+ticket.humanStatus
//			+"\n\tcode: "+ticket.code
//			+"\n\nTotal: "+dec.format(ticket.total));
//			} else {
//				//System.out.println("Do nat have that ticket");
//				//return;
//			}
//
//		}
//		//return tickets;
//	}
//
//	public void addTicket(Ticket ticket) {
//        tickets.add(ticket);
//    }
//
//    public ArrayList<Ticket> getTickets() {
//        return tickets;
//    }
//
//
//
//	public Ticket(String type,String date,double price,String discount2,String code,String humanStatus2) {
//		//setType(type);
//		//setDate(date);
//		//setPrice(price);
//		//setDiscount(discount2);
//		//setHumanStatus(humanStatus2);
//		this.zoneType = type;
//		this.date = date;
//		this.price = price;
//		this.discount = discount2;
//		this.code = code;
//		this.humanStatus = humanStatus2;
//		//setCode(code);
//	}
//
//	public void setTotal(double total) {
//		this.total = total;
//	}
//	public double getTotal() {
//		return total;
//	}
//	public void setHumanStatus(Object humanStatus) {
//		this.humanStatus = humanStatus;
//	}
//	public Object getHumanStatus() {
//		return humanStatus;
//	}
//
//	public void setType(String type) {
//		this.zoneType = type;
//	}
//
//	public Object getType() {
//		return zoneType;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//
//	public String getDate() {
//		return date;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setDiscount(String discount2) {
//		this.discount = discount2;
//	}
//
//	public Object getDiscount() {
//		return discount;
//	}
//

//
//
//
//
//	public Ticket(){
//	}
//
//	// Ticket builder
//	public static class Builder {
//
//		private double price;
//		private String date;
//		private Object discount;
//		private Object animalZone;
//		private Object humanStatus;
//
//		public Builder withPrice(double price){
//			this.price = price;
//			return this;
//		}
//
//		public Builder withDate(String date) {
//			this.date = date;
//			return this;
//		}
//
//		public Builder withAnimalZoneType(String object) {
//			this.animalZone = object;
//			return this;
//		}
//
//		public Builder withDiscount(Object object) {
//			this.discount = object;
//			return this;
//		}
//
//		public Builder withHumanStatus(String humanStatus) {
//			this.humanStatus = humanStatus;
//			return this;
//		}
//
//
//
//		/**
//		 * Calculates total amount of price.
//		 *
//		 * @param ticket
//		 * @return price-discount
//		 */
//		public double calcualteTotal(Ticket ticket) {
//			double price = ticket.price;
//			double disc = (double) ticket.discount;
//			double newPrice =(price-(price*disc));
//			return newPrice;
//		}
//
//
//		public Ticket build() {
//			Ticket ticket = new Ticket();
//			ticket.price = this.price;
//			ticket.date = this.date;
//			ticket.animalZone = this.animalZone;
//			ticket.discount = this.discount;
//			ticket.humanStatus = this.humanStatus;
//			ticket.code = genCode();
//			ticket.total = calcualteTotal(ticket);
//			tickets.add(ticket);
//			return ticket;
//		}
//
//	}

//    public void setCode(String code) {
//        if (code == "null") {
//            this.code = genCode();
//        } else {
//            this.code = code;
//        }
//    }
}
