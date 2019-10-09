package ua.flatsandroom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/add")
public class addFlatServlet extends HttpServlet {
    private House house = new House();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        final String area = request.getParameter("area");
        final String address = request.getParameter("address");
        final String squarein = request.getParameter("square");
        final String numberOfRoomsin = request.getParameter("numberOfRooms");
        final String pricein = request.getParameter("price");

        Double square = Double.parseDouble(squarein);
        int numberOfRooms = Integer.parseInt(numberOfRoomsin);
        Double price = Double.parseDouble(pricein);

        List<Flat> listflat = new ArrayList<>();

        Flat flat = new Flat(area, address, square, numberOfRooms, price);

        listflat.add(flat);
        try {
            house.addHouse(listflat);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("houselist", house.getHouse());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/outputFlats.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
