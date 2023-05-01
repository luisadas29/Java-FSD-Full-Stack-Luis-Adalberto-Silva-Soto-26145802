package com.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bean.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	
	//@Query(value="select * from orders l where l.ordersid = :ordersid and l.emailid = :emailid and l.order_placed=:order_placed and l.productid=:productid and l.quantity_of_products=:quantity_of_products",nativeQuery = true)
	//public Orders  report(@Param("ordersid") int ordersid,
		//	@Param("emailid") String emailid,
		//@Param("order_placed") LocalDate order_placed, @Param("productid") int productid, @Param("quantity_of_products") int quantity_of_products);
	
	
	//@Query(value="select * from orders l where l.order_placed = :order_placed ",nativeQuery = true)
	//public Orders dateReport(@Param("ordersid") int ordersid,
		//	@Param("emailid") String emailid,
		//@Param("order_placed") LocalDate order_placed, @Param("productid") int productid, @Param("quantity_of_products") int quantity_of_products);
      
	//@Query(value="select * from orders l where l.order_placed = :orderPlaced ",nativeQuery = true)
	//public List<Orders> findByOrderDate(@Param("ordersID") int ordersid,@Param("orderPlaced") LocalDate orderPlaced,@Param("productID") Integer productid,@Param("emailID") String emailid,@Param("quantityOfProducts") int quantityOfProducts );
    
	//List<Orders> findByOrderPlacedIn(LocalDate localDate );
	//@Repository
	//public interface OrdersRepository1 extends JpaRepository<Orders,OrdersKey>{
		
		//@Query(value="select * from orders l where l.ordersid=:ordersID or l.order_placed = :orderPlaced ",nativeQuery = true)
		//public Orders findAll(@Param("ordersID") Integer ordersID, @Param("orderPlaced") LocalDate orderPlaced);

		
		//@Param("ordersID") Integer ordersID, 
	//}


}




