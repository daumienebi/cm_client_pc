package es.daumienebi.comicmanagement.utils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * 
 * @author Daumienebi Sakpa
 *
 *This class will be used from different parts of the app so its better to have it here
 */
public class HttpClientUtil {

	final static CloseableHttpClient httpClient = HttpClients.createDefault();
	
	public static HttpEntity get(String url) throws Exception{
		HttpGet request = new HttpGet(url);
		
		CloseableHttpResponse response = httpClient.execute(request);
		HttpEntity entity  = response.getEntity();
		if(response.getStatusLine().getStatusCode() != 200) {
			System.out.println("The server is currently down");
		}else {
			//The entity can only be consume once, or else it will give an error that u are trying to read a closed stream
			//System.out.println(EntityUtils.toString(entity));
		}
		return entity;
	}
	
	public static void post(StringEntity entity,String url) throws Exception{
		//Probably return the statusCode and control it in the Service class
		HttpPost post = new HttpPost(url);
		post.setEntity(entity);
		
		CloseableHttpResponse response = httpClient.execute(post);
		if(response.getStatusLine().getStatusCode() != 200) {
			System.out.println("Error Adding the entity");
		}
		response.close();//important shit
	}
	
	public static boolean delete(String url) throws Exception{
		//Probably return the statusCode and control it in the Service class
		HttpDelete delete = new HttpDelete(url);
		CloseableHttpResponse response =  httpClient.execute(delete);
		if(response.getStatusLine().getStatusCode() != 200) {
			System.out.println("Error Deleting the entity");
			return false;
		}
		response.close();
		return true;
	}
}
