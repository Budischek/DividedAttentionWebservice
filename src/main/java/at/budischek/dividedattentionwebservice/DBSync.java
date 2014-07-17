package at.budischek.dividedattentionwebservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Path("/dbsync")
public class DBSync {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getTestsInJSON() {
		Gson gson = new Gson();
		DBConnection con = new DBConnection();
		ArrayList<Test> tests = con.queryTests();
		ArrayList<TestDistance> testdistances = con.queryTestDistances();
		ArrayList<TestReaction> testreactions = con.queryTestReactions();
		
		String output = gson.toJson(tests)+" "+gson.toJson(testdistances)+" "+gson.toJson(testreactions);
		
		return output;
	}	
	
    @POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(String testJson) {
		Gson gson = new Gson();
		String[] temp = testJson.split("\\]\\s\\[");
		System.out.println(temp[0]);
		System.out.println(temp[1]);
		System.out.println(temp[2]);
		String output = temp[0] + "###########################################################" + temp[1];
		String temptests = temp[0]+"]";
		ArrayList<Test> tests = gson.fromJson(temptests, new TypeToken<List<Test>>(){}.getType());
		String distances = "["+temp[1]+"]";
		ArrayList<TestDistance> testdistances = gson.fromJson(distances, new TypeToken<List<TestDistance>>(){}.getType());
		String reactions = "["+temp[2];
		ArrayList<TestReaction> testreactions = gson.fromJson(reactions, new TypeToken<List<TestReaction>>(){}.getType());
		output = "";
		for(Test t : tests) {
			output+="\n"+t.toString();
		}
		for(TestDistance td : testdistances) {
			output+="\n"+td.toString();
		}
		//TODO Save to DB instead of returning it
		for(TestReaction tr : testreactions) {
			output+="\n"+tr.toString();
		}
		return Response.status(201).entity(output).build();
 
	}
	
	@GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
	    return "Hello Jersey";
	  }
} 