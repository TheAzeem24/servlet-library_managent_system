import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/SearchByAuthor")
public class SearchByAuthor extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String author = req.getParameter("input1");
		ArrayList arrayList = SeachByAuthorJdbc.searchBook(author);
		PrintWriter printWriter = res.getWriter();
		Iterator iterator = arrayList.iterator();
		while(iterator.hasNext())
		{
			Object object = iterator.next();
			printWriter.println(object);
		}
			
	}

}
