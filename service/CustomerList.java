package com.atproject1.service;

import com.atproject1.bean.Customer;

/*
 * manager customer objects, and provide methods to add update delete traverse
 * to be called by CustomerView
 */
public class CustomerList {

	private Customer[] customers; //customer objects
	private int total; //customer object number
	
	//initialize Customer[]
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];//capacity
	}
	
	//add customer into array, return true if add successfully
	public boolean addCustomer(Customer customer) {
		if(total >= customers.length) {
			return false;
		}
		customers[total] = customer;
		total++;
		return true;
	}
	
	//replace customer information at index position, return true if replace successfully 
	public boolean replaceCustomer(int index, Customer customer) {
		if(index<0 || index>=total) {
			return false;
		}
		customers[index] = customer;
		return true;
	}
	
	//delete customer information at index position, return true if delete successfully
	public boolean deleteCustomer(int index) {
		if(index<0 || index>=total) {
			return false;
		}
		for(int i=index; i<total-1; i++) {
			customers[i] = customers[i+1];
		}
		customers[total-1] = null; //set the last element null
		total--;
		return true;
	}
	
	//get all customers' information
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for(int i=0; i<total; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	
	//get customer information at index position
	public Customer getCustomer(int index) {
		if(index<0 || index>=total) {
			return null;
		}
		return customers[index];
	}
	
	//get the number of customers
	public int getTotal() {
		return total;
	}
}
