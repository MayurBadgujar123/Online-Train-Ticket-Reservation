/*
 * package com.shashi.servlets;
 * 
 * import java.io.IOException; import java.io.PrintWriter;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import com.shashi.beans.TrainBean; import com.shashi.beans.TrainException;
 * import com.shashi.constant.ResponseCode; import com.shashi.constant.UserRole;
 * import com.shashi.service.TrainService; import
 * com.shashi.service.impl.TrainServiceImpl; import
 * com.shashi.utility.TrainUtil;
 * 
 * @WebServlet("/adminaddtrain") public class AdminAddTrain extends HttpServlet
 * {
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * private TrainService trainService = new TrainServiceImpl();
 * 
 * protected void doPost(HttpServletRequest req, HttpServletResponse res) throws
 * IOException, ServletException { res.setContentType("text/html"); PrintWriter
 * pw = res.getWriter(); TrainUtil.validateUserAuthorization(req,
 * UserRole.ADMIN); try { TrainBean train = new TrainBean(); String trainNo =
 * req.getParameter("trainno"); String trainName =
 * req.getParameter("trainname"); String fromStation =
 * req.getParameter("fromstation"); String toStation =
 * req.getParameter("tostation"); String seatsStr =
 * req.getParameter("available"); String fareStr = req.getParameter("fare");
 * 
 * if (trainNo == null || trainNo.isEmpty() || trainName == null ||
 * trainName.isEmpty() || fromStation == null || fromStation.isEmpty() ||
 * toStation == null || toStation.isEmpty() || seatsStr == null ||
 * seatsStr.isEmpty() || fareStr == null || fareStr.isEmpty()) { throw new
 * TrainException(422, this.getClass().getName() + "_FAILED",
 * "All fields are required"); }
 * 
 * train.setTr_no(Long.parseLong(trainNo));
 * train.setTr_name(trainName.toUpperCase());
 * train.setFrom_stn(fromStation.toUpperCase());
 * train.setTo_stn(toStation.toUpperCase());
 * train.setSeats(Integer.parseInt(seatsStr));
 * train.setFare(Double.parseDouble(fareStr));
 * 
 * String message = trainService.addTrain(train); if
 * (ResponseCode.SUCCESS.toString().equalsIgnoreCase(message)) {
 * RequestDispatcher rd = req.getRequestDispatcher("AddTrains.html");
 * rd.include(req, res); pw.
 * println("<div class='tab'><p1 class='menu'>Train Added Successfully!</p1></div>"
 * ); } else { RequestDispatcher rd =
 * req.getRequestDispatcher("AddTrains.html"); rd.include(req, res); pw.
 * println("<div class='tab'><p1 class='menu'>Error in filling the train Detail</p1></div>"
 * ); } } catch (NumberFormatException e) { throw new TrainException(422,
 * this.getClass().getName() + "_FAILED", "Invalid numeric value provided"); }
 * catch (Exception e) { throw new TrainException(422, this.getClass().getName()
 * + "_FAILED", e.getMessage()); } } }
 */
package com.shashi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.beans.TrainBean;
import com.shashi.beans.TrainException;
import com.shashi.constant.ResponseCode;
import com.shashi.constant.UserRole;
import com.shashi.service.TrainService;
import com.shashi.service.impl.TrainServiceImpl;
import com.shashi.utility.TrainUtil;

@WebServlet("/adminaddtrain")
public class AdminAddTrain extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private TrainService trainService = new TrainServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        TrainUtil.validateUserAuthorization(req, UserRole.ADMIN);
        try {
            TrainBean train = new TrainBean();
            String trainNo = req.getParameter("trainno");
            String trainName = req.getParameter("trainname");
            String fromStation = req.getParameter("fromstation");
            String toStation = req.getParameter("tostation");
            String seatsStr = req.getParameter("available");
            String fareStr = req.getParameter("fare");

            if (trainNo == null || trainNo.isEmpty() || trainName == null || trainName.isEmpty()
                    || fromStation == null || fromStation.isEmpty() || toStation == null || toStation.isEmpty()
                    || seatsStr == null || seatsStr.isEmpty() || fareStr == null || fareStr.isEmpty()) {
                throw new TrainException(422, this.getClass().getName() + "_FAILED", "All fields are required");
            }

            train.setTr_no(Long.parseLong(trainNo));
            train.setTr_name(trainName.toUpperCase());
            train.setFrom_stn(fromStation.toUpperCase());
            train.setTo_stn(toStation.toUpperCase());
            train.setSeats(Integer.parseInt(seatsStr));
            train.setFare(Double.parseDouble(fareStr));

            String message = trainService.addTrain(train);
            if (ResponseCode.SUCCESS.toString().equalsIgnoreCase(message)) {
                RequestDispatcher rd = req.getRequestDispatcher("AddTrains.html");
                rd.include(req, res);
                pw.println("<div class='tab'><p1 class='menu'>Train Added Successfully!</p1></div>");
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("AddTrains.html");
                rd.include(req, res);
                pw.println("<div class='tab'><p1 class='menu'>Error in filling the train Detail</p1></div>");
            }
        } catch (NumberFormatException e) {
            throw new TrainException(422, this.getClass().getName() + "_FAILED", "Invalid numeric value provided");
        } catch (Exception e) {
            throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
        }
    }
}
