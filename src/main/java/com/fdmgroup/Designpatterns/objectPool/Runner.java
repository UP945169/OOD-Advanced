package com.fdmgroup.Designpatterns.objectPool;

public class Runner {

	public static void main(String[] args) {
		ConnectionPool connectionPool = new ConnectionPool(1,3);
		
		Connection connection1 = connectionPool.borrowConnection();
		connection1.connect("UNIX server");
		
		Connection connection2 = connectionPool.borrowConnection();
		connection2.connect("Windows server");

		Connection connection3 = connectionPool.borrowConnection();
		connection3.connect("Mac");
		
//		Connection connection4 = connectionPool.borrowConnection();
//		connection4.connect("Android");
		
		

	}

}
