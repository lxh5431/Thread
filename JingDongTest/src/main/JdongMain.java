package main;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import db.MYSQLControl;
import model.JdModel;
import util.URLFecter;

public class JdongMain {
	 static final Log logger = LogFactory.getLog(JdongMain.class);
	    public static void main(String[] args) throws Exception {
	        //��ʼ��һ��httpclient
	        HttpClient client = new DefaultHttpClient();
	        //����Ҫ��ȡ��һ����ַ��������Դ����ݿ��г�ȡ���ݣ�Ȼ������ѭ����������ȡһ��URL����
	        String url="http://search.jd.com/Search?keyword=Python&enc=utf-8&book=y&wq=Python&pvid=33xo9lni.p4a1qb";
	        //ץȡ������
	        List<JdModel> bookdatas=URLFecter.URLParser(client, url);
	        //ѭ�����ץȡ������
	        for (JdModel jd:bookdatas) {
	            logger.info("bookID:"+jd.getBookID()+"\t"+"bookPrice:"+jd.getBookPrice()+"\t"+"bookName:"+jd.getBookName());
	        }
	        //��ץȡ�����ݲ������ݿ�
	        MYSQLControl.executeInsert(bookdatas);
	    }
}
