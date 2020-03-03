package main;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

	private Customer customer; //cliente
	private Salesman salesman;//vendedor
	private Date orderedOn;
	private String deliveryStreet;
	private String deliveryCity;
	private String deliveryCountry;
	private Set<OrderItem> items;

	public Order(Customer customer, Salesman salesman, String deliveryStreet, String deliveryCity, String deliveryCountry, Date orderedOn) {
		this.customer = customer;
		this.salesman = salesman;
		this.deliveryStreet = deliveryStreet;
		this.deliveryCity = deliveryCity;
		this.deliveryCountry = deliveryCountry;
		this.orderedOn = orderedOn;
		this.items = new HashSet<OrderItem>();
	}

	public Customer getCustomer() {
		return customer;
	}

	public Salesman getSalesman() {
		return salesman;
	}

	public Date getOrderedOn() {
		return orderedOn;
	}

	public String getDeliveryStreet() {
		return deliveryStreet;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public String getDeliveryCountry() {
		return deliveryCountry;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public float total() {
		float totalItems = 0;
		float totalShipping=0;
		totalItems = calculateTotalForItems(totalItems);

		if (this.deliveryCountry == "USA"){
			// total=totalItems + tax + 0 shipping
			return totalItems + totalItems * 5 / 100;
		}

		// total=totalItemst + tax + 15 shipping
		return totalItems + totalItems * 5 / 100 + 15;
	}

	private float calculateTotalForItems(float totalItems) {
		for (OrderItem item : items) {
			float totalItem=0;
			float itemAmount = item.getProduct().getUnitPrice() * item.getQuantity();
			totalItem = getAccessories(item, totalItem, itemAmount);
			totalItem = getBikes(item, totalItem, itemAmount);
			totalItem = getCloathing(item, totalItem, itemAmount);
			totalItems += totalItem;
		}
		return totalItems;
	}
	

	
	private float getCloathing(OrderItem item, float totalItem, float itemAmount) {
		if (item.getProduct().getCategory() == ProductCategory.Cloathing) {
			
			totalItem = itemAmount - item.getProduct().getUnitPrice();
		}
		return totalItem;
	}

	private float getBikes(OrderItem item, float totalItem, float itemAmount) {
		if (item.getProduct().getCategory() == ProductCategory.Bikes) {
			// 20% discount for Bikes
			totalItem = itemAmount - itemAmount * 20 / 100;
			
		}
		return totalItem;
	}

	private float getAccessories(OrderItem item, float totalItem, float itemAmount) {
		if (item.getProduct().getCategory() == ProductCategory.Accessories) {
			
			totalItem = itemAmount - itemAmount*10/100;
		}
		return totalItem;
	}
}
