package crawlerTest;



import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
	public static void main(String[] args) throws IOException {
		String html="<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
	Document doc=Jsoup.parse(html);
	System.out.println(doc);
	
	 String url="http://www.tripadvisor.com/SearchForums?q=airbnb&x=18&y=10&pid=34633&s=+";
     Document doc1=Jsoup.connect(url).userAgent("bbb").timeout(50000).get();
     Elements ele=doc1.select("table[class=forumsearchresults]").select("tr[class~=firstpostrow?]");
     for (Element elem:ele) {
         String _id=elem.attr("id");
         String _url="http://www.tripadvisor.com"+elem.select("td[onclick~=setPID?]").select("a").
                 attr("href");
         String _content=elem.select("td[onclick~=setPID?]").select("a").text();
         System.out.println(_id+"===="+_url+"===="+_content);
     }
 }

}
