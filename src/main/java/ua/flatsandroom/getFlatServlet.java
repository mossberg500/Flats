package ua.flatsandroom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/get")
public class getFlatServlet extends HttpServlet {
    private House house = new House();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Flat> list = new ArrayList<>();
        String area = request.getParameter("area");
        String address = request.getParameter("address");
        String square = request.getParameter("square");
        if (area == null) area = "";
        if (address == null) address = "";
        if (square == null) square = "";
        try {
            list = house.getFlats(area, address, square);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("filter", list);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/filter.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Flat> list = new ArrayList<>();
        final String area = "";
        final String address = "";
        final String square = "";
        try {
            list = house.getFlats(area, address, square);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("filter", list);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/filter.jsp");
        dispatcher.forward(request, response);
    }
}
