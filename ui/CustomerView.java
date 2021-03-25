package com.atproject1.ui;

import com.atproject1.bean.Customer;
import com.atproject1.service.CustomerList;
import com.atproject1.util.CMUtility;

/*
 * customer information management
 * main module, show and deal with users' operation
 */
public class CustomerView {
	private CustomerList customerList = new CustomerList(10);
	
	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		
		view.enterMainMenu();
		
		System.out.println("\n        		        	Thank you for visiting.");
	}
	
	//show the interface of <<customer information management>>
	public void enterMainMenu() {
		boolean flag = true;
		
		while(flag) {
			System.out.println("\n		---------- Welocom to <<customer information management interface>> ----------\n");
			System.out.println("                    			1. show customer");
			System.out.println("					2. add customer");
			System.out.println("					3. replace customer");
			System.out.println("					4. delete customer");
			System.out.println("					5. exit\n");
			System.out.print("please choose from 1 to 5: ");
			System.out.println("\n		---------- Welocom to <<customer information management interface>> ----------\n");
			
			char choice = CMUtility.readMenuSelection();
			switch(choice) {
			case '1':
				listAllCustomers();
				break;
			case '2':
				addNewCustomer();
				break;
			case '3':
				modifyCustomer();
				break;
			case '4':
				deleteCustomer();
				break;
			case '5':
				System.out.print("Are you sure to exit(Y/N)?");
				char ch = CMUtility.readConfirmSelection();
				if(ch == 'Y') {
					flag = false;
				}
				break;
			}
		}
	}
	
	//add customer
	private void addNewCustomer() {
		System.out.println("		-------------------------------- add  customer -------------------------------\n");
		
		System.out.print("				Name: ");
		String name = CMUtility.readString(20);
		System.out.print("				Gender: ");
		char gender = CMUtility.readChar();
		System.out.print("				Age: ");
		int age = CMUtility.readInt();
		System.out.print("				Phone: ");
		String phone = CMUtility.readString(10);
		
		Customer customer = new Customer(name,gender,age,phone);
		boolean added = customerList.addCustomer(customer);
		if(added) {
			System.out.println("					Add customer successfully");
		}else {
			System.out.println("					Add customer fail");
		}
		
		System.out.print("\n		------------------------------ add customer over -----------------------------\n");
	}
	
	//modify customer
	private void modifyCustomer() {
		System.out.println("		------------------------------- modify customer ------------------------------\n");
		
		while(true) {
			System.out.println("please enter the No of customer to be modified(-1 exit): ");
			int number = CMUtility.readInt();
			if(number == -1) {
				System.out.println("            		    	exit from modifing customer");
				break; 
			}
			
			Customer customer = customerList.getCustomer(number-1);
			if(customer == null) {
				System.out.println("            		    	can't find the customer to be modified");
				continue;
			}else { //found the customer to be modified
				System.out.print("				Name("+customer.getName()+"): ");
				String name = CMUtility.readString(20, customer.getName());
				System.out.print("				Gender("+customer.getGender()+"): ");
				char gender = CMUtility.readChar(customer.getGender());
				System.out.print("				Age("+customer.getAge()+"): ");
				int age = CMUtility.readInt(customer.getAge());
				System.out.print("				Phone("+customer.getPhone()+"): ");
				String phone = CMUtility.readString(10, customer.getPhone());
				
				Customer newCustomer = new Customer(name, gender, age, phone);
				boolean isModified = customerList.replaceCustomer(number-1, newCustomer);
				if(isModified) {
					System.out.println("          			        modify customer successfully.");
				}else {
					System.out.println("            		    	modify customer fail.");
				}
				break;
			}
		}
		
		System.out.print("\n		----------------------------- modify customer over ---------------------------\n");
	}
	
	//delete customer
	private void deleteCustomer() {
		System.out.println("		------------------------------- delete customer ------------------------------\n");
		
		while(true) {
			System.out.println("please enter the No of customer to be deleted(-1 exit): ");
			int number = CMUtility.readInt();
			if(number == -1) {
				System.out.println("            		    	exit from deleting customer");
				break; 
			}
			
			Customer customer = customerList.getCustomer(number-1);
			if(customer == null) {
				System.out.println("            		    	can't find the customer to be deleted");
				continue;
			}else {
				System.out.print("Are you sure to delete(Y/N)?");
				char flag = CMUtility.readConfirmSelection();
				if(flag == 'Y') {
					boolean isDeleted = customerList.deleteCustomer(number - 1);
					if(isDeleted) {
						System.out.println("          			        delete customer successfully.");
					}else {
						System.out.println("            		    	delete customer fail.");
					}
				}
				break;
			}
		}
		
		System.out.print("\n		----------------------------- delete customer over ---------------------------\n");
	}
	
	//show customer list
	private void listAllCustomers() {
		System.out.println("		-------------------------------- show customer -------------------------------\n");
		
		Customer[] cus = customerList.getAllCustomers();
		if(cus.length == 0) {
			System.out.println("					No customer information is available.");
		}else {
			System.out.print("				");
			System.out.println("No.\tName\t\tGender\tAge\tPhone");
			for(int i=0; i<cus.length; i++) {
				System.out.print("				");
				System.out.println(i+1+"\t"+cus[i].getName()+"\t\t"+cus[i].getGender()+"\t"+cus[i].getAge()+"\t"+cus[i].getPhone());
			}
		}
		System.out.print("\n		------------------------------ show customer over ----------------------------\n");
	}
}
