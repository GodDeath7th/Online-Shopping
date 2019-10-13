package unitofwork;

import java.util.ArrayList;

import datasource.OrderMapper;
import dto.Order;;

public class OrderUnitOfWork {
	private ArrayList<Order> newOrders;
	private ArrayList<Order> deleteOrders;
	private OrderMapper orderMapper;
	
	public OrderUnitOfWork() {
		orderMapper = new OrderMapper();
	}
	
	public boolean addOrder(Order order, boolean instantCommit) {
		if(newOrders == null) {
			newOrders = new ArrayList<>();
		}
		newOrders.add(order);
		
		if(instantCommit) {
			return doCommit()[0];
		}
		return true;
	}

	public boolean deleteOrder(Order order, boolean instantCommit) {
		if(deleteOrders == null) {
			deleteOrders = new ArrayList<>();
		}
		deleteOrders.add(order);
		
		if(instantCommit) {
			return doCommit()[2];
		}
		
		return true;
	}
	
	public ArrayList<Order> getOrderByUserId(int userId){
		ArrayList<Order> thisUserOrders = orderMapper.getOrderByUserId(userId);
		return thisUserOrders;
	}
	
	public boolean[] doCommit() {
		boolean isNewSuccess = true;
		boolean isUpdateSuccess = true;
		boolean isDeleteSuccess = true;
		
		if(newOrders != null) {
			if(newOrders.size() > 0) {
				if(orderMapper.insert(newOrders)){
					newOrders.clear();
				}
				else {
					isNewSuccess = false;
				}
			}
		}
		if(deleteOrders != null) {
			if(deleteOrders.size() > 0 ) {
				if(orderMapper.delete(deleteOrders)) {
					deleteOrders.clear();
				}
				else {
					isDeleteSuccess = false;
				}
			}
		}
		
		return new boolean[] {isNewSuccess, isUpdateSuccess, isDeleteSuccess};
	}
}