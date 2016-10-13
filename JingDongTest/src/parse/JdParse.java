package parse;

import java.util.ArrayList;
import java.util.List;



import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.JdModel;

public class JdParse {
	 public static List<JdModel> getData (String html) throws Exception{
	        //��ȡ�����ݣ�����ڼ�����
	        List<JdModel> data = new ArrayList<JdModel>();
	        //����Jsoup����
	        Document doc = (Document) Jsoup.parse(html);
	        //��ȡhtml��ǩ�е�����
	        Elements elements=((org.jsoup.nodes.Element) doc).select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
	        for (org.jsoup.nodes.Element ele:elements) {
	            String bookID=ele.attr("data-sku");
	            String bookPrice=ele.select("div[class=p-price]").select("strong").select("i").text();
	            String bookName=ele.select("div[class=p-name]").select("em").text();
	            //����һ������������Կ�����ʹ��Model�����ƣ�ֱ�ӽ��з�װ
	            JdModel jdModel=new JdModel();
	            //�����ֵ
	            jdModel.setBookID(bookID);
	            jdModel.setBookName(bookName);
	            jdModel.setBookPrice(bookPrice);
	            //��ÿһ�������ֵ�����浽List������
	            data.add(jdModel);
	        }
	        //��������
	        return data;
	    }

}