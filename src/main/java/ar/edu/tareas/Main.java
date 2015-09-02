package ar.edu.tareas;

import spark.Spark;
import ar.edu.tareas.controller.TareasController;
import ar.edu.tareas.controller.util.JsonTransformer;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		JsonTransformer jsonTransformer = new JsonTransformer(gson);

		Spark.port(9000);
		Spark.staticFileLocation("/public");

		new TareasController(jsonTransformer).register();
	}
}
