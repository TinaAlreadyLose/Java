package JavaJson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Creatjson {

	public static void main(String[] args) {
		JsonObject object =new JsonObject();
		 object.addProperty("cat", "it");
		 JsonArray array=new JsonArray();
		
		 JsonObject lan1=new JsonObject();
		 lan1.addProperty("id", 1);
		 lan1.addProperty("name", "java");
		 lan1.addProperty("ide", "eclispe");
		 array.add(lan1);
		 
		 JsonObject lan2=new JsonObject();
		 lan2.addProperty("id", 2);
		 lan2.addProperty("name", "Swift");
		 lan2.addProperty("ide", "Xcode");
		 array.add(lan2);
		 	
		 JsonObject lan3=new JsonObject();
		 lan3.addProperty("id", 3);
		 lan3.addProperty("name", "c#");
		 lan3.addProperty("ide", "vs");
		 array.add(lan3);
		 
		 object.add("language", array);	
		 object.addProperty("pop", true);
		 System.out.println(object.toString());
	}

}
