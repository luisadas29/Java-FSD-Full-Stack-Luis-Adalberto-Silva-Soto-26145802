import React, { useState, useEffect } from "react";
import axios from "axios";
import "../Orders.css";

function AllOrders() {
  const [orderHistory, setOrderHistory] = useState([]);
  const [filteredOrders, setFilteredOrders] = useState([]);
  const [sortBy, setSortBy] = useState("orderDate"); 
  const [searchQuery, setSearchQuery] = useState("");
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 10; 

  useEffect(() => {
    fetchOrderHistory();
  }, []);

  useEffect(() => {
    filterOrders();
  }, [orderHistory, searchQuery]);

  const fetchOrderHistory = async () => {
    try {
      const response = await axios.get("http://localhost:8080/orders/allOrders");
      setOrderHistory(response.data);
    } catch (error) {
      console.error("Error fetching order history:", error);
    }
  };

  const filterOrders = () => {
    const filtered = orderHistory.filter(
      (order) =>
        order.orderid.toString().includes(searchQuery) ||
        order.totalCost.toFixed(2).includes(searchQuery) ||
        new Date(order.orderDate).toLocaleDateString().includes(searchQuery)
    );
    setFilteredOrders(filtered);
  };

  const handleSortChange = (event) => {
    setSortBy(event.target.value);
  };

  const compareOrders = (a, b) => {
    if (sortBy === "orderid") {
      return a.orderid - b.orderid;
    } else if (sortBy === "totalCost") {
      return a.totalCost - b.totalCost;
    } else {
      const dateA = new Date(a.orderDate).getTime();
      const dateB = new Date(b.orderDate).getTime();
      return dateA - dateB;
    }
  };

  const totalPages = Math.ceil(filteredOrders.length / itemsPerPage);
  const startIndex = (currentPage - 1) * itemsPerPage;
  const endIndex = startIndex + itemsPerPage;
  const currentOrders = filteredOrders.slice(startIndex, endIndex);

  const handlePageChange = (pageNumber) => {
    setCurrentPage(pageNumber);
  };

  return (
    <div className="container mt-4">
      <h2 className="orders-title">All Order History</h2>
      <div className="filter-sort">
        <input
          type="text"
          placeholder="Search by order ID, total cost, or date"
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
        <label>Sort by:</label>
        <select value={sortBy} onChange={handleSortChange}>
          <option value="orderDate">Order Date</option>
          <option value="orderid">Order ID</option>
          <option value="totalCost">Total Cost</option>
        </select>
      </div>
      <table className="table orders-table">
        <thead>
          <tr>
            <th>Order ID</th>
            <th>Total Cost (£)</th>
            <th>Order Date</th>
            <th>Items</th>
          </tr>
        </thead>
        <tbody>
          {currentOrders.length > 0 ? (
            currentOrders.sort(compareOrders).map((order) => (
              <tr key={order.orderid}>
                <td>{order.orderid}</td>
                <td>{order.totalCost.toFixed(2)}</td>
                <td>{new Date(order.orderDate).toLocaleDateString()}</td>
                <td>
                  <ul className="order-items-list">
                    {order.orderItemStrings && order.orderItemStrings.length > 0 ? (
                      JSON.parse(order.orderItemStrings).map((item, index) => (
                        <li key={index}>{item}</li>
                      ))
                    ) : (
                      <li>No items</li>
                    )}
                  </ul>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4" className="no-orders-text">
                You have no order history.
              </td>
            </tr>
          )}
        </tbody>
      </table>
      <div className="pagination">
        {Array.from({ length: totalPages }, (_, index) => (
          <button
            key={index}
            onClick={() => handlePageChange(index + 1)}
            className={currentPage === index + 1 ? "active" : ""}
          >
            {index + 1}
          </button>
        ))}
      </div>
    </div>
  );
}

export default AllOrders;


