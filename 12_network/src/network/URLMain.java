package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

// *.java <--BufferedReaader-- 버퍼 <--InputStreamReader-- 내 컴 <--url.openStream-- 웹
// Reader 문자 단위, InputStream 바이트 단위 

public class URLMain {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/index.html");
		System.out.println("프로토콜 = " + url.getProtocol());
		System.out.println("호스트 = " + url.getHost());
		System.out.println("포트 = " + url.getPort());
		System.out.println("기본 포트 = " + url.getDefaultPort());
		System.out.println("파일 = " + url.getFile());
		System.out.println();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;
		
		while( (line = br.readLine()) != null ) {
			System.out.println(line);
		}
		br.close();
	}
}

//자바스크립트 스타트업이나 외국계 가려면 목숨 걸고 공부해야한다