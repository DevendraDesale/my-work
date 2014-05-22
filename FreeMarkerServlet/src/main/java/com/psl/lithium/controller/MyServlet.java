package com.psl.lithium.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.MessageContext;

import com.psl.lithium.model.User;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static List<User> users;

	private String company = "Persistent Systems Limited";

	static {
		users = new ArrayList<>();
		users.add(new User("Devendra", "Desale"));
		users.add(new User("Ramesh", "Sharma"));
		users.add(new User("Ashish", "Bhosale"));
		users.add(new User("Pranav", "Sawant"));
	}

	/**
	 * Default constructor.
	 */
	public MyServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("users", users);
		request.setAttribute("company", company);
		request.getRequestDispatcher("/index.ftl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");

		if (null != firstname && null != lastname && !firstname.isEmpty()
				&& !lastname.isEmpty()) {

			synchronized (users) {
				users.add(new User(firstname, lastname));
			}

		}

		doGet(request, response);
	}

}
