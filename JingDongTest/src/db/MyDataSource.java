package db;

import javax.sql.DataSource;

public class MyDataSource {
	public static DataSource getDataSource(String connectURI){
        BasicDataSource ds = new BasicDataSource();
         //MySQL��jdbc����
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");              //��Ҫ���ӵ����ݿ���
        ds.setPassword("123456");                //MySQL�ĵ�½����
        ds.setUrl(connectURI);
        return ds;
    } 

}