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

import org.hibernate.Session;

import at.budischek.dividedattentionwebservice.model.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Path("/dbsync")
public class DBSync {
	@GET
	@Path("test{testid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTestInJSON(@PathParam("testid") String paramId) {
		int id = 0;
		try{
			id = Integer.parseInt(paramId);
		}
		catch (Exception e) {
			return e.getStackTrace().toString();
		}
		Test outputTest;
		ArrayList<TestDistance> outputDistances = new ArrayList<TestDistance>();
		ArrayList<TestReaction> outputReactions = new ArrayList<TestReaction>();
		Gson gson = new Gson();
		DBConnection con = new DBConnection();
		ArrayList<Test> tests = con.queryTests();
		ArrayList<TestDistance> testdistances = con.queryTestDistances();
		ArrayList<TestReaction> testreactions = con.queryTestReactions();
		outputTest = Test.findTestById(tests, id);
		outputDistances = TestDistance.findTestDistanceByTestId(testdistances, id);
		outputReactions = TestReaction.findTestReactionByTestId(testreactions, id);
		String output = gson.toJson(outputTest)+" "+gson.toJson(outputDistances)+" "+gson.toJson(outputReactions);
		
		return output;
	}	
	
	@GET
	@Path("drugpattern{drugid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDrugInJSON(@PathParam("drugid") String paramId) {
		int id = 0;
		try{
			id = Integer.parseInt(paramId);
		}
		catch (Exception e) {
			return e.getStackTrace().toString();
		}
		Muster outputMuster;
		Cause outputCause;
		ArrayList<MusterDistance> outputDistances = new ArrayList<MusterDistance>();
		ArrayList<MusterReaction> outputReactions = new ArrayList<MusterReaction>();
		Gson gson = new Gson();
		DBConnection con = new DBConnection();
		ArrayList<Muster> musters = con.queryMuster();
		ArrayList<MusterDistance> musterdistances = con.queryMusterDistances();
		ArrayList<MusterReaction> musterreactions = con.queryMusterReactions();
		ArrayList<Cause> causes = con.queryCauses();
		outputMuster = Muster.findMusterById(musters, id);
		outputCause = Cause.findCauseById(causes, id);
		outputDistances = MusterDistance.findMusterDistanceByTestId(musterdistances, id);
		outputReactions = MusterReaction.findMusterReactionByTestId(musterreactions, id);
		String output = gson.toJson(outputMuster)+" "+gson.toJson(outputDistances)+" "+gson.toJson(outputReactions)+" "+gson.toJson(outputCause);
		
		return output;
	}
	
	@GET
	@Path("drugnames")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDrugInJSON() {
		Gson gson = new Gson();
		DBConnection con = new DBConnection();
		ArrayList<Muster> musters = con.queryMuster();
		ArrayList<Cause> causes = con.queryCauses();
		String output = gson.toJson(musters)+" "+gson.toJson(causes);
		return output;
	}
	
	@GET
	@Path("tests")
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
	
	@GET
	@Path("pfad{pfadid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPfadInJSON(@PathParam("pfadid") String paramId) {
		int id = 0;
		try{
			id = Integer.parseInt(paramId);
		}
		catch (Exception e) {
			return e.getStackTrace().toString();
		}
		ArrayList<Punktbewegung> outputPunkte = new ArrayList<Punktbewegung>();
		Gson gson = new Gson();
		DBConnection con = new DBConnection();
		ArrayList<Punktbewegung> punktbewegungs = con.queryPunktbewegung();
		for(Punktbewegung punktbewegung:punktbewegungs) {
			if(punktbewegung.getPfad()==id) {
				outputPunkte.add(punktbewegung);
			}
		}
		String output = gson.toJson(outputPunkte);
		return output;
	}
	
    @POST
	@Path("/postTestMuster")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response createDBfromJSON(String testMuster) {
    	String[] temp = new String[2];
    	temp = testMuster.split("=");
    	System.out.println(testMuster);
    	if(temp.length==2) {
    		int test = Integer.parseInt(temp[0]);
    		int muster = Integer.parseInt(temp[1]);
			DBConnection con = new DBConnection();
			Session session = con.session;
			session.beginTransaction();
			TestMuster tm = new TestMuster();
			tm.setTest(test);
			tm.setMuster(muster);
			session.save(tm);
		    session.getTransaction().commit();
			return Response.status(201).entity("Successfully added TestMuster").build();
    	}
	    return Response.status(400).entity("Error, input not valid").build();
	}
} 