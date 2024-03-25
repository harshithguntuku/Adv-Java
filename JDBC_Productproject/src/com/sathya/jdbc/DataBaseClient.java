package com.sathya.jdbc;

public class DataBaseClient {

	public static void main(String[] args) //Main method for Entering data
	{ 
		ProductDao productDao = new ProductDao();
		
		int res1 = productDao.saveProduct(new Product(3001,"Apple Airpods Pro",24000));
		System.out.println("Data inserted successfully "+res1);
		

		int res2 = productDao.saveProduct(new Product(3002,"Boat Airdopes",1500));
		System.out.println("Data inserted successfully "+res2);
		

		int res3 = productDao.saveProduct(new Product(3003,"JBL Tune 235NC ",6500));
		System.out.println("Data inserted successfully "+res3);
	

		int res4 = productDao.saveProduct(new Product(3004,"OnePlus Buds Z2",4999));
		System.out.println("Data inserted successfully "+res4);
		

		int res5 = productDao.saveProduct(new Product(3005,"Nothing Ear 1", 7999));
		System.out.println("Data inserted successfully "+res5);
	}

}
