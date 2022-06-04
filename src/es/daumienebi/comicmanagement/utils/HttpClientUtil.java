package es.daumienebi.comicmanagement.utils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

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
}
