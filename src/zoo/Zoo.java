package zoo;
public class Zoo {
/**
* 
* @author Martins Buhanovskis
*
*/
	public static void main(String[] args) {
		Visitor visitor = new Visitor("Anna","Student");
		Shop shop = new Shop();
		shop.sellTicketWithoutVoucher(visitor,"General");
		shop.giveToCustomerVoucher(visitor, 20);
		shop.checkAllTicketStatuses(visitor.getTicketList());
		shop.sellTicketAddingVoucher(visitor,"Petting",visitor.getVoucherCode(1));
	}	
}
