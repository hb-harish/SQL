import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class SQL {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Files f = new Files();
			
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();

		
		
		while(true)
		{
			System.out.println("\nType your SQL statement and type Quit to quit:");	
			String s = sc.nextLine();
			if (s.equalsIgnoreCase("quit"))
			{
				System.out.println("Well okay let us call it a day. See you later.");
				break;
			}
			try 
			{
				pstmt = con.prepareStatement(s);
			} 
			catch (SQLException e2) 
			{
				e2.printStackTrace();
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			String c ="";
			int nc = rsmd.getColumnCount();
			c = rsmd.getColumnName(1);
			for (int i =2; i<=nc; i++)
			{
				c = String.format("%s\t%s",c,rsmd.getColumnName(i));
				
			}
			c = String.format("%s\n",c);
			System.out.print(c);
			f.addlog(c);
			int j =1;
			String res ="";
			while(rs.next())
			{
				res ="";
				for (int i =1; i<=nc; i++)
				{
					res += rs.getString(i) + '\t';
					
					
					
				}
				res +="\n";
				if(j<=10)
				{
					System.out.print(res);
				}
				
				f.addlog(res);
				j++;
			}
			
			f.logFile();
		}

		}catch (SQLException e) 
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e) 
		{
				e.printStackTrace();
		}
//		finally 
//		{
//				try 
//				{
//					rs.close();
//					pstmt.close();
//					con.close();
//				}catch(SQLException e)
//				{
//					e.printStackTrace();
//				}
//			}
		}

}
