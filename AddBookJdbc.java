import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddBookJdbc 
{
	public static void addBook(String bookId,String bookName,String bookAuthor,String bookType,Double bookPrice)
	{
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		String query = "insert into test.book values(?,?,?,?,?)";
		Connection connection;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bookId);
			preparedStatement.setString(2, bookName);
			preparedStatement.setString(3, bookAuthor);
			preparedStatement.setString(4, bookType);
			preparedStatement.setDouble(5, bookPrice);
			preparedStatement.executeUpdate();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
