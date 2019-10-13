package domainlogic;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import dto.Address;
import dto.Buyer;
import dto.BuyerOrientedItem;
import dto.Cart;
import dto.Comment;
import dto.Message;
import dto.Order;
import dto.Seller;
import dto.SellerOrientedItem;
import dto.User;
import dto.UserAuthentication;
import unitofwork.*;

public class BehaviorConductor {
	// let unit of work take charge of object in service
	// initialize all unit of work
	UserUnitOfWork userUOW;
	UserAuthUnitOfWork userAuthUOW;
	BuyerUnitOfWork buyerUOW;
	SellerUnitOfWork sellerUOW;
	AddressUnitOfWork addressUOW;
	CartUnitOfWork cartUOW;
	OrderUnitOfWork orderUOW;
	CommentUnitOfWork commentUOW;
	MessageUnitOfWork messageUOW;
	SellerOrientedItemUnitOfWork sellerItemUOW;
	
	boolean isLock = false;
	
	public BehaviorConductor() {
		userUOW = new UserUnitOfWork();
		userAuthUOW = new UserAuthUnitOfWork();
		buyerUOW = new BuyerUnitOfWork();
		sellerUOW = new SellerUnitOfWork();
		addressUOW = new AddressUnitOfWork();
		cartUOW = new CartUnitOfWork();
		orderUOW = new OrderUnitOfWork();
		commentUOW = new CommentUnitOfWork();
		messageUOW = new MessageUnitOfWork();
		sellerItemUOW = new SellerOrientedItemUnitOfWork();
	}
	
	public void waitInQueue() {
		while(isLock) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		isLock = true;
	}
	
	public void doNotifyAll() {
		isLock = false;
		notifyAll();
	}
	
	public synchronized UserAuthentication login(String phoneNumber, String password, String userType) {
		waitInQueue();
		UserAuthentication thisUserAuth = userAuthUOW.login(phoneNumber, password, userType);
		if(thisUserAuth != null) {
			User thisUser = userUOW.getUserById(thisUserAuth.getUserId());
			if(thisUser.getUserType().equals("buyer")) {
				buyerUOW.getBuyerById(thisUser.getId());
			}
			else {
				sellerUOW.getSellerById(thisUser.getId());
			}
		}		
		doNotifyAll();
		return thisUserAuth;
	}
	
	public synchronized boolean logout(int userId) {
		waitInQueue();
		boolean isSuccess = userAuthUOW.logout(userId);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean register(User user) {
		waitInQueue();
		if(userUOW.isUserExisted(user)) {
			doNotifyAll();
			return false;
		}
		
		if(userUOW.addUser(user, true)){
			User thisUser = userUOW.getUserByPair(user.getPhoneNumber(), user.getUserType());
			UserAuthentication thisUserAuth = new UserAuthentication();
			thisUserAuth.setUserId(thisUser.getId());
			thisUserAuth.setPhoneNumber(thisUser.getPhoneNumber());
			thisUserAuth.setPassword(thisUser.getPassword());
			thisUserAuth.setUserType(thisUser.getUserType());
			if(thisUser.getUserType().equals("buyer")) {
				Buyer thisBuyer = new Buyer();
				thisBuyer.setId(thisUser.getId());
				thisBuyer.setBalnce(0);
				boolean isSuccess = buyerUOW.addBuyer(thisBuyer, true) && userAuthUOW.addUserAuth(thisUserAuth, true);
				doNotifyAll();
				return isSuccess;
			}
			
			else if(thisUser.getUserType().equals("seller")) {
				Seller thisSeller = new Seller();
				thisSeller.setId(thisUser.getId());
				thisSeller.setIncome(0);
				boolean isSuccess = sellerUOW.addSeller(thisSeller, true) && userAuthUOW.addUserAuth(thisUserAuth, true);
				doNotifyAll();
				return isSuccess;
			}
			else {
				doNotifyAll();
				return false;
			}
		}
		else {
			doNotifyAll();
			return false;
		}
	}
	
	public synchronized boolean isUserExisted(User user) {
		waitInQueue();
		boolean isSuccess =  userUOW.isUserExisted(user);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean isUserLogged(String phoneNumber, String userType) {
		waitInQueue();
		boolean isSuccess = userAuthUOW.isUserLogged(phoneNumber, userType);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized Buyer getBuyerById(int userId) {
		waitInQueue();
		Buyer thisBuyer =  buyerUOW.getBuyerById(userId);
		doNotifyAll();
		return thisBuyer;
	}
	
	public synchronized Seller getSellerById(int userId) {
		waitInQueue();
		Seller thisSeller = sellerUOW.getSellerById(userId);
		doNotifyAll();
		return thisSeller;
	}
	
	public synchronized User getProfile(int userId) {
		waitInQueue();
		User thisUser = userUOW.getUserById(userId);
		doNotifyAll();
		return thisUser;
	}
	
	public synchronized boolean editProfile(User user) {
		waitInQueue();
		boolean isSuccess = userUOW.updateUser(user, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized ArrayList<SellerOrientedItem> getAllItems(){
		waitInQueue();
		ArrayList<SellerOrientedItem> items = sellerItemUOW.getItemsByRange("ALL", null);
		doNotifyAll();
		return items;
	}
	
	public synchronized ArrayList<SellerOrientedItem> getItemById(String itemId){
		waitInQueue();
		ArrayList<SellerOrientedItem> items = sellerItemUOW.getItemsByRange("ITEM_ID", new String[] {itemId});
		doNotifyAll();
		return items;
	}
	
	public synchronized ArrayList<SellerOrientedItem> getItemsBySellerId(String sellerId){
		waitInQueue();
		ArrayList<SellerOrientedItem> items = sellerItemUOW.getItemsByRange("SELLER_ID", new String[] {sellerId});
		doNotifyAll();
		return items;
	}
	
	public synchronized ArrayList<SellerOrientedItem> getItemsByKeyword(String keyword) {
		waitInQueue();
		ArrayList<SellerOrientedItem> items = sellerItemUOW.getItemsByRange("KEYWORD", new String[] {keyword});
		doNotifyAll();
		return items;
	}
	
	public synchronized ArrayList<Cart> getCart(int buyerId) {
		waitInQueue();
		ArrayList<Cart> carts = cartUOW.getCartsByBuyerId(buyerId);
		doNotifyAll();
		return carts;
	}
	
	public boolean addToCart(Cart cart) {
		waitInQueue();
		boolean isSuccess = cartUOW.addCart(cart, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean removeFromCart(Cart cart) {
		waitInQueue();
		boolean isSuccess = cartUOW.deleteCart(cart, true);
		doNotifyAll();
		return isSuccess;
	}

	public synchronized ArrayList<Address> getAddresses(int userId){
		waitInQueue();
		ArrayList<Address> addrs = addressUOW.getAddressesByUserId(userId);
		doNotifyAll();
		return addrs;
	}
	
	public boolean addAddress(Address address) {
		waitInQueue();
		boolean isSuccess = addressUOW.addAddress(address, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean updateAddress(Address address) {
		waitInQueue();
		boolean isSuccess = addressUOW.updateAddress(address, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean deleteAddress(Address address) {
		waitInQueue();
		boolean isSuccess = addressUOW.deleteAddress(address, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean changeBalance(int buyerId, float money) {
		waitInQueue();
		boolean isSuccess = buyerUOW.changeBalance(buyerId, money);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean changeStock(int itemId, int stock) {
		waitInQueue();
		boolean isSuccess = sellerItemUOW.changeStock(itemId, stock);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean changeIncome(int sellerId, float money) {
		waitInQueue();
		boolean isSuccess = sellerUOW.changeIncome(sellerId, money);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized String purchase(int userId) {
		waitInQueue();
		// get balance of this user
		Buyer thisBuyer = this.getBuyerById(userId);
		float balance = thisBuyer.getBalance();
		// calculate total price in cart and check stock from each good during calculation
		float totalPrice = Float.parseFloat("0");
		ArrayList<Cart> carts = this.getCart(userId);
		
		for(Cart cart: carts) {
			int eachRequiredNumber = cart.getBuyerItem().getNumber();

			ArrayList<SellerOrientedItem> correspondingItems = this.getItemById(String.valueOf(cart.getBuyerItem().getItemId()));
			int eachLeftStock = correspondingItems.get(0).getStock();
			// if any one of good in cart has no enough stock
			if(eachLeftStock < eachRequiredNumber) {
				doNotifyAll();
				return "out_of_stock";
			}
			else {
				float eachTotalPrice = correspondingItems.get(0).getPrice()*eachRequiredNumber;
				totalPrice = totalPrice + eachTotalPrice;
			}
		}
		
		// if this buyer balance is not enough
		if(balance < totalPrice) {
			doNotifyAll();
			return "no_enough_money";
		}
		// then purchase
		else {
			ArrayList<Address> thisBuyerAddr = this.getAddresses(userId);
			for(Cart cart: carts) {
				Order thisOrder = new Order();
				thisOrder.setAddress(thisBuyerAddr.get(0));
				thisOrder.setBuyerId(userId);
				thisOrder.setItemId(cart.getBuyerItem().getItemId());
				thisOrder.setItemName(cart.getBuyerItem().getName());
				thisOrder.setPriceForEach(cart.getBuyerItem().getPrice());
				thisOrder.setPurchaseNumber(cart.getBuyerItem().getNumber());
				thisOrder.setTotalPrice(thisOrder.getPriceForEach()*thisOrder.getPurchaseNumber());
				thisOrder.setDate(new Date(new java.util.Date().getTime()));
				ArrayList<SellerOrientedItem> correspondingItems = this.getItemById(String.valueOf(thisOrder.getItemId()));
				thisOrder.setSellerId(correspondingItems.get(0).getSellerId());
				
				this.changeBalance(userId, -thisOrder.getTotalPrice());
				this.changeStock(thisOrder.getItemId(), -thisOrder.getPurchaseNumber());
				this.changeIncome(thisOrder.getSellerId(), thisOrder.getTotalPrice());
				orderUOW.addOrder(thisOrder, true);
				this.removeFromCart(cart);
			}
		}
		doNotifyAll();
		return "success";
	}
	
	public synchronized boolean addItem(SellerOrientedItem sellerItem) {
		waitInQueue();
		boolean isSuccess = sellerItemUOW.addSellerItem(sellerItem, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean updateItem(SellerOrientedItem sellerItem) {
		waitInQueue();
		boolean isSuccess = sellerItemUOW.updateSellerItem(sellerItem, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean deleteItem(SellerOrientedItem sellerItem) {
		waitInQueue();
		boolean isSuccess = sellerItemUOW.deleteSellerItem(sellerItem, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized ArrayList<Order> getOrders(int userId) {
		waitInQueue();
		ArrayList<Order> orders = orderUOW.getOrderByUserId(userId);
		doNotifyAll();
		return orders;
	}
	
	public synchronized boolean addOrder(Order order) {
		waitInQueue();
		boolean isSuccess = orderUOW.addOrder(order, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean deleteOrder(Order order) {
		waitInQueue();
		boolean isSuccess = orderUOW.deleteOrder(order, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean sendMessage(Message msg) {
		waitInQueue();
		boolean isSuccess =  messageUOW.addMessage(msg, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized ArrayList<Message> getReceiveMessages(String toName) {
		waitInQueue();
		ArrayList<Message> msgs = messageUOW.getMessagesByRange("TO_NAME", new String[] {toName});
		doNotifyAll();
		return msgs;
	}
	
	public synchronized ArrayList<Message> getSendMessages(String fromName) {
		waitInQueue();
		ArrayList<Message> msgs = messageUOW.getMessagesByRange("FROM_NAME", new String[] {fromName});
		doNotifyAll();
		return msgs;
	}
	
	public synchronized boolean deleteMessage(Message message) {
		waitInQueue();
		boolean isSuccess = messageUOW.deleteMessage(message, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized ArrayList<Comment> getCommentsByUserId(int userId) {
		waitInQueue();
		ArrayList<Comment> comments = commentUOW.getCommentsByRange("USER_ID", new String[] {String.valueOf(userId)});
		doNotifyAll();
		return comments;
	}

	public synchronized ArrayList<Comment> getCommentsByItemId(int itemId) {
		waitInQueue();
		ArrayList<Comment> comments = commentUOW.getCommentsByRange("ITEM_ID", new String[] {String.valueOf(itemId)});
		doNotifyAll();
		return comments;
	}
	
	public synchronized boolean makeComment(Comment comment) {
		waitInQueue();
		boolean isSuccess = commentUOW.addComment(comment, true);
		doNotifyAll();
		return isSuccess;
	}
	
	public synchronized boolean deleteComment(Comment comment) {
		waitInQueue();
		boolean isSuccess = commentUOW.deleteComment(comment, true);
		doNotifyAll();
		return isSuccess;
	}

}
