import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SeachByAuthorJdbc 
{
	public static ArrayList searchBook(String author)
	{
		ArrayList arrayList = new ArrayList();
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		String query = "select from test.book where author=?";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, author);
			ResultSet resultSet = preparedStatement.executeQuery();
			String bId = resultSet.getString("id");
			String bTitle = resultSet.getString("title");
			String bAuthor = resultSet.getString("author");
			String bType = resultSet.getString("type");
			Double bPrice = resultSet.getDouble("price");
			
			arrayList.add(bId);
			arrayList.add(bTitle);
			arrayList.add(bAuthor);
			arrayList.add(bType);
			arrayList.add(bPrice);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return arrayList;
		
	}
}
