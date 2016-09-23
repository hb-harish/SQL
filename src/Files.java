import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Files {
	
	protected static ArrayList<String> logList = new ArrayList<String>();
	
	public void addlog(String resp) {
		logList.add(resp);
	}
	
	public ArrayList<String> getLogList() {
		int size = logList.size();
		return logList;
	}
	
	public void logFile() {
		PrintWriter writer = null;
		try {
			try {
				writer = new PrintWriter("Output.txt","UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		writer.println(logList);
		writer.flush();
		writer.close();
		System.out.print("Your results have been written to Output.txt");
	}
	
	public void logQuery(String n, String s ) {
		PrintWriter writer = null;
		try {

			writer = new PrintWriter(new FileOutputStream("Query.txt", true ));

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		writer.println(n + " | " + s);
		writer.flush();
		writer.close();
		System.out.print("Your results have been written to Output.txt");
	}
	
	public String getQueryNames() 
	{	
		Scanner sc = null;
		String name = "";
		File file = new File("/home/oracle/workspace/java/SqlUtility/Query.txt");
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.useDelimiter("\\|");
		int i =1;
		while (sc.hasNextLine())
		{
			name += i+ ". " +sc.next() + "\n";
			sc.nextLine();
			i++;
		}
		sc.close();
		return name;
		
		
	}
	public String getQuery(int x) 
	{	
		String q="";
		Scanner sc =null;
		File file = new File("/home/oracle/workspace/java/SqlUtility/Query.txt");
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.useDelimiter("\\|");
		int i =1;
		while (sc.hasNextLine())
		{
			sc.next();
			if (i==x) q = sc.next();
			i++;
		}
		sc.close();
		return q;
		
		
	}

}
