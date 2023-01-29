/**
 * 
 */
package com.debajoy.ds.heap.level1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Debajoy
 *
 */
public class Arcesium {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
	//		URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding");
			URL url = new URL("https://api.covid19api.com/summary");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			if(conn.getResponseCode() == 200) {
				Scanner scan = new Scanner(url.openStream());
				while(scan.hasNext()) {
					String temp = scan.nextLine();
                  	//parse json here
                }
            }
       }catch(Exception ex){
    	   throw ex;
       }
	}

}
