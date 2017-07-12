package MyService;

import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.ResultSetMetaData;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("klarf")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("GetJsonData")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonData(@QueryParam("lotid") String lotid,@QueryParam("waferid") int waferid) 
    //public String getJsonData() 
    {
 
    	DBOper dbo = new DBOper();
        ResultSet ret = null;
        JSONArray array = new JSONArray();
        try 
        {
			ret = dbo.selectdata(lotid,waferid);
        	//ret = dbo.selectdata();
			ResultSetMetaData metaData = (ResultSetMetaData) ret.getMetaData();
			int colnmnCount = metaData.getColumnCount();
			while(ret.next())
			{
				JSONObject jsonObj = new JSONObject();
				for(int i = 1;i <= colnmnCount; i ++)
				{
					String columnName = metaData.getColumnName(i);
					String value = ret.getString(columnName);
					jsonObj.put(columnName, value);
				}
				array.put(jsonObj);
			}
			
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally
        {
        	dbo.db1.close();
        }
        
		return array.toString();
    }
    
    @GET
    @Path("GetConfig")
    @Produces(MediaType.APPLICATION_JSON)
    public String getconfig() 
    {
        DBOper dbo = new DBOper();
        ResultSet ret = null;
        String s = null;
        JSONArray array = new JSONArray();
        try 
        {
			ret = dbo.selectconfig();
			ResultSetMetaData metaData = (ResultSetMetaData) ret.getMetaData();
			int colnmnCount = metaData.getColumnCount();
			//System.out.println(colnmnCount);
			while(ret.next())
			{
				JSONObject jsonObj = new JSONObject();
				for(int i = 1;i <= colnmnCount; i ++)
				{
					String columnName = metaData.getColumnName(i);
					String value = ret.getString(columnName);
					jsonObj.put(columnName, value);
				}
				array.put(jsonObj);
			}	
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally
        {
        	dbo.db1.close();
        }
        
		return array.toString();
		
		
    }
    
    @GET
    @Path("GetDefectImage")
    @Produces(MediaType.APPLICATION_JSON)
    public String getdefectimage(@QueryParam("lotid") String lotid,@QueryParam("waferid") int waferid,@QueryParam("xindex") String xindex,@QueryParam("yindex") String yindex) 
    {
        DBOper dbo = new DBOper();
        ResultSet ret = null;
        String s = null;
        JSONArray array = new JSONArray();
        try 
        {
			ret = dbo.selectdefectiamge(lotid,waferid,xindex,yindex);
			ResultSetMetaData metaData = (ResultSetMetaData) ret.getMetaData();
			int colnmnCount = metaData.getColumnCount();
			//System.out.println(colnmnCount);
			while(ret.next())
			{
				JSONObject jsonObj = new JSONObject();
				for(int i = 1;i <= colnmnCount; i ++)
				{
					String columnName = metaData.getColumnName(i);
					String value = ret.getString(columnName);
					jsonObj.put(columnName, value);
				}
				array.put(jsonObj);
			}	
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally
        {
        	dbo.db1.close();
        }
        
		return array.toString();
		
		
    }
}
