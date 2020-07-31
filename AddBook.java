import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/AddBook")
public class AddBook extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String bookId = req.getParameter("input1");
		String bookName = req.getParameter("input2");
		String bookAuthor = req.getParameter("input3");
		String bookType = req.getParameter("input4");
		String Price = req.getParameter("input5");
		Double bookPrice = Double.parseDouble(Price);
		AddBookJdbc.addBook(bookId, bookName, bookAuthor, bookType, bookPrice);
		PrintWriter printWriter = res.getWriter();
		printWriter.println("Book Successfully Added");
	}

}
