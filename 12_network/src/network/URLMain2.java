package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLMain2 {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.goldria.net/m/product_list.html?xcode=012");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line;
		
		while( (line=br.readLine()) != null) {
			System.out.println(line.indexOf("14k"));
		}
		br.close();
		
		//indexof활용, 사이트의 소스를 읽어서 14k 검색
	}
}

