package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	public Order() {

	}

	public Order(Client client) {
		this.client = client;
		this.moment = new Date(System.currentTimeMillis());
		this.status = OrderStatus.PROCESSING;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public List<OrderItem> getOrderItens() {
		return orderItems;
	}

	public void addItem(OrderItem item) {
		this.orderItems.add(item);
	}

	public void removeItem(OrderItem item) {
		this.orderItems.remove(item);
	}

	public Double total() {
		double total = 0;
		for (OrderItem orderItem : orderItems) {
			total += orderItem.subTotal();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER SUMMARY:\n");
		sb.append("Order moment: " + getMoment());
		sb.append("\nOrder status: " + getStatus());
		sb.append("\nClient: " + client.getName() + " " + client.getBirthDate() + " - " + client.getEmail());
		sb.append("\nOrder items: \n");
		for (OrderItem orderItem : orderItems) {
			sb.append(orderItem + "\n");
		}
		sb.append("Total price: " + total());
		return sb.toString();

	}

}
