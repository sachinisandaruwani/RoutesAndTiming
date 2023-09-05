package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Routes;
import com.db.DBUtils;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/RouteController")
public class RouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RouteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String param = request.getParameter("controlParam");

		switch (param) {
		case "bookingList":
			bookingList(request, response);
			break;
		case "LOAD":
			loadBooking(request, response);
			break;
		case "DELETE":
			deleteBooking(request, response);
			break;

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//
		String param = request.getParameter("controlParam");

		switch (param) {
		//
		case "booking-form":
			insertBooking(request, response);
			break;
		case "bookingList":
			bookingList(request, response);
			break;
		case "update-booking":
			updateBooking(request, response);
			break;

		}

	}

	private void bookingList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Routes> bookingList = DBUtils.bookingList();
		request.setAttribute("boolingList", bookingList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/booking-list.jsp");
		dispatcher.forward(request, response);
		
	}

	//
	private void insertBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int status = 0;
		
		//		validation
		if(request.getParameter("start").equalsIgnoreCase("") || request.getParameter("destination").equalsIgnoreCase("") ||
				request.getParameter("time").equalsIgnoreCase("0") || request.getParameter("vehicleType").equalsIgnoreCase("0") ||
				request.getParameter("vehicle-id").equalsIgnoreCase("")) {
			
			request.setAttribute("nullError", "nullError");
			RequestDispatcher rd = request.getRequestDispatcher("route.jsp");
			rd.forward(request, response);
		
		} else if(request.getParameter("start").equalsIgnoreCase(request.getParameter("destination"))) {
			
			request.setAttribute("sameStation", "sameStation");
			RequestDispatcher rd = request.getRequestDispatcher("route.jsp");
			rd.forward(request, response);
			
		} else {
			
			String start = request.getParameter("start");
			String destination = request.getParameter("destination");
			String bookingDate = request.getParameter("bookingDate");
			String time = request.getParameter("time");
			String vehicleId = request.getParameter("vehicle-id");
			String vehicleType = request.getParameter("vehicleType");
	
			Routes bookingObj = new Routes(start, destination, bookingDate, time, vehicleId, vehicleType);
	
			status = DBUtils.insertBooking(bookingObj);
			
		}

		if (status == 1) {
			request.setAttribute("success", "success");
			RequestDispatcher rd = request.getRequestDispatcher("route.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("insert-error", "insert-error");
			RequestDispatcher rd = request.getRequestDispatcher("route.jsp");
			rd.forward(request, response);
		}
			

	}
	
	private void loadBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		
		Routes b = DBUtils.getBooking(bookingId);
		request.setAttribute("getBooking", b);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-booking.jsp");
		dispatcher.forward(request, response);
		
	}

	private void updateBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("bookingID"));
		String bookingDate = request.getParameter("bookingDate");
		String time = request.getParameter("time");
		String vehicleID = request.getParameter("vehicleID");
		String vehicleType = request.getParameter("vehicleType");
		
		Routes b = new Routes();
		b.setId(id);
		b.setDate(bookingDate);
		b.setTime(time);
		b.setVehicleID(vehicleID);
		b.setVehicleType(vehicleType);
		
		DBUtils.updateBooking(b);
		bookingList(request, response);
		
	}
	
	private void deleteBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookingID = Integer.parseInt(request.getParameter("bookingId"));
		DBUtils.deleteBooking(bookingID);
		bookingList(request, response);
		
	}

}
