package MyService;

import java.sql.ResultSet;  
import java.sql.SQLException;
 

public class DBOper 
{
	String sql = null;  
	DBHelper db1 = null;  
	ResultSet ret = null;  
    
	public ResultSet selectdata(String lotid , int waferid) throws Exception
	//public ResultSet selectdata() throws Exception
	{
		sql = "select XINDEX,YINDEX,XREL,YREL,DEFECTAREA from defectinfo where lotid = ? and waferid = ? order by defectid asc";
		//sql = "select XINDEX,YINDEX,XREL,YREL,DEFECTAREA from defectinfo order by defectid asc";
		try
		{
			db1 = new DBHelper(sql);
			db1.pst.setString(1,lotid);
			db1.pst.setInt(2,waferid);
            ret = db1.pst.executeQuery();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ret;
		
	}
	
	public ResultSet selectconfig() throws Exception
	//public ResultSet selectdata() throws Exception
	{
		sql = "select * from Klarf_config where configname = 'mapinfo'";
		//sql = "select XINDEX,YINDEX,XREL,YREL,DEFECTAREA from defectinfo order by defectid asc";
		try
		{
			db1 = new DBHelper(sql);
            ret = db1.pst.executeQuery();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ret;
		
	}
	
	public ResultSet selectdefectiamge(String lotid , int waferid,String xindex , String yindex) throws Exception
	{
		sql = "select lotid,waferid,defectid,imagename from defectinfo where lotid = ? and waferid = ? and xindex = ? and yindex = ? order by defectid asc";
		//sql = "select XINDEX,YINDEX,XREL,YREL,DEFECTAREA from defectinfo order by defectid asc";
		try
		{
			db1 = new DBHelper(sql);
			db1.pst.setString(1,lotid);
			db1.pst.setInt(2,waferid);
			db1.pst.setString(3,xindex);
			db1.pst.setString(4,yindex);
            ret = db1.pst.executeQuery();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ret;
		
	}
}
