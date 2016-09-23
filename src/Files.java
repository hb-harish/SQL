import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;

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

}
