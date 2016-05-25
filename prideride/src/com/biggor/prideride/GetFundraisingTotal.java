package com.biggor.prideride;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@SuppressWarnings("serial")
public class GetFundraisingTotal extends HttpServlet {

	Integer total = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		
		total= 0;
		
		resp.getWriter().println("Rodney: " + getAmountRaised("https://www.canadahelps.org/en/pages/priderideorg/"));
		resp.getWriter().println("Gary: " + getAmountRaised("https://www.canadahelps.org/en/pages/pride-ride-3/"));
		resp.getWriter().println("Glenn: " + getAmountRaised("https://www.canadahelps.org/en/pages/pride-ride-2/"));
		resp.getWriter().println("Julie: " + getAmountRaised("https://www.canadahelps.org/en/pages/priderideca/"));
		resp.getWriter().println("Allison: " + getAmountRaised("https://www.canadahelps.org/en/pages/fundraising-for-lgbt-youthline/"));
		resp.getWriter().println("Sal: " + getAmountRaised("https://www.canadahelps.org/en/pages/cycling-until-the-end/"));
		resp.getWriter().println("Victor and Mark: " + getAmountRaised("https://www.canadahelps.org/en/pages/victor-and-marks-pride-ride/"));
		resp.getWriter().println("Calvin: " + getAmountRaised("https://www.canadahelps.org/en/pages/calvins-pride-ride/"));
		resp.getWriter().println("Billy: " + getAmountRaised("https://www.canadahelps.org/en/pages/billys-pride-ride/"));
		resp.getWriter().println("Frank: " + getAmountRaised("https://www.canadahelps.org/en/pages/pride-ride-4/"));
		
		
		resp.getWriter().println("-------------------");
		resp.getWriter().println("total: " + total.toString());
		resp.getWriter().println("grand total: " + (total + 10325));
	}
	
	private String getAmountRaised(String url) throws IOException {
		Document doc = Jsoup.connect(url).timeout(10000).get();
		String amountraised = doc.select("p.amount-raised").select("span").get(0).text();
		total = total + Integer.valueOf(amountraised.replace("$", "").replace(",", ""));
		return amountraised;
	}

}
