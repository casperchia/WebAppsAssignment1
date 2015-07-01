package edu.unsw.comp9321;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.InputSource;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Set default page.
	    String nextPage = "search.jsp";
	    
		String action = request.getParameter("action");
		if(action.equals("welcome")){
			nextPage = "search.jsp";
		}else if(action.equals("searchRequest")){
					
			ServletContext context = getServletContext();
			InputSource xmlFile = new InputSource(context.getResourceAsStream("/WEB-INF/ands_registry_dc.xml"));
			ResultManager rm = new ResultManager(xmlFile);
		
			String searchInput = request.getParameter("searchInput");
			if(searchInput.contentEquals("")){
				request.setAttribute("isEmptySearch", true);
			}else{
				request.setAttribute("isEmptySearch", false);
	            ArrayList<ResultBean> results = rm.getResults(searchInput);

	            SearchListBean searchList = (SearchListBean) request.getSession().getAttribute("searchList");
	            searchList.setSearchList(results);
	            
	            request.getSession().setAttribute("pageNumber", 0);
	            request.setAttribute("resultSize", results.size());
			}
            nextPage="results.jsp";
			
		}else if(action.equals("nextPage")){
			int currentPage = Integer.parseInt(request.getSession().getAttribute("pageNumber").toString());
//			System.out.println(currentPage);
			currentPage++;
			request.getSession().setAttribute("pageNumber", currentPage);
            SearchListBean searchList = (SearchListBean) request.getSession().getAttribute("searchList");
            ArrayList<ResultBean> tempResults = searchList.getSearchList();
            int remainingPages = tempResults.size() - (currentPage * 10);
            request.setAttribute("resultSize", remainingPages);
            
			nextPage="results.jsp";
			
		}else if(action.equals("previousPage")){
			int currentPage = Integer.parseInt(request.getSession().getAttribute("pageNumber").toString());
//			System.out.println(currentPage);
			currentPage--;
			request.getSession().setAttribute("pageNumber", currentPage);
            SearchListBean searchList = (SearchListBean) request.getSession().getAttribute("searchList");
            ArrayList<ResultBean> tempResults = searchList.getSearchList();
            int remainingPages = tempResults.size() - (currentPage * 10);
            request.setAttribute("resultSize", remainingPages);
            
			nextPage="results.jsp";
			
		}else if(action.equals("shopCart")){
			OrderBean order = (OrderBean) request.getSession().getAttribute("order");
			ArrayList<ResultBean> orders = order.getOrders();
			if(orders.size() == 0){
				request.setAttribute("isCartEmpty", true);
			}else{
				request.setAttribute("isCartEmpty", false);				
			}
			nextPage = "shoppingCart.jsp";
		}else if(action.equals("info")){
			SearchListBean searchListBean = (SearchListBean) request.getSession().getAttribute("searchList");
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<ResultBean> results = searchListBean.getSearchList();
			ResultBean resultBean = results.get(id);
			request.getSession().setAttribute("result", resultBean);
			nextPage="information.jsp";
		}
	    
	    // Dispatch Control.
	    RequestDispatcher myRequestDispatcher = request.getRequestDispatcher("/"+nextPage);
        myRequestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set default page.
	    String nextPage = "search.jsp";
	    
		String action = request.getParameter("action");

		if(action.equals("add")){
			ResultBean result = (ResultBean) request.getSession().getAttribute("result");
			OrderBean order = (OrderBean) request.getSession().getAttribute("order");
			ArrayList<ResultBean> orders = order.getOrders();
			orders.add(result);
			order.setOrders(orders);
			request.setAttribute("myOrder", result);
			
			if(orders.size() == 0){
				request.setAttribute("isCartEmpty", true);
			}else{
				request.setAttribute("isCartEmpty", false);				
			}
			
			nextPage="shoppingCart.jsp";
		}else if(action.equals("remove")){
			OrderBean order = (OrderBean) request.getSession().getAttribute("order");
			ArrayList<ResultBean> orders = order.getOrders();
			String[] selectedResults = request.getParameterValues("resultChecked");
			if(selectedResults != null){
				for(int i = 0; i < selectedResults.length; i++){
					for(int j = 0; j < orders.size(); j++){
						if(orders.get(j).getTitle().contentEquals(selectedResults[i])){
//							System.out.println("removed:" + orders.get(j).getTitle());
							orders.remove(j);
						}
					}
				}
			}
			order.setOrders(orders);
			
			if(orders.size() == 0){
				request.setAttribute("isCartEmpty", true);
			}else{
				request.setAttribute("isCartEmpty", false);				
			}
			
			nextPage="shoppingCart.jsp";
		}
		
		// Dispatch Control.
	    RequestDispatcher myRequestDispatcher = request.getRequestDispatcher("/"+nextPage);
        myRequestDispatcher.forward(request, response);	
	}

}
