package demo;


import com.google.gson.Gson;

import static spark.Spark.*;

public class LotoMain {
    public static void main(String[] args) {
//

        LotoDao lotoDao = new LotoDao();
//        lotoDao.getTopWins().forEach(c-> System.out.println(c));


      //  lotoDao.getAllLotoUsers().forEach(c -> System.out.println(c));

        port(8010);

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/lotousers", (request, response) ->{
            Gson gson=new Gson();
            return  gson.toJson( lotoDao.getAllLotoUsers());
        });

        get("/lototopwins", (request, response) ->{
            Gson gson=new Gson();
            return  gson.toJson( lotoDao.getTopWins());
        });

        post("/addloto", (request, response) ->{
            String name=request.queryParams("name");
            int amount =Integer.parseInt(request.queryParams("amount"));

            LotoModel lotoModel=new LotoModel(name, amount) ;
            lotoDao.addloto(lotoModel);
            Gson gson=new Gson();

            return gson.toJson(lotoModel);
        });


        after((request, response) -> {
            response.type("application/json");
        });


    }
}