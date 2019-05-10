import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieTitles {
    String[] getMovieTitles(String substr) {
        String response;
        int page = 1;
        int totalpages = Integer.MAX_VALUE;
        List<String> titles = new ArrayList<String>();
        while (page <= totalpages) {
            try {
                URL obj = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + page);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                BufferedReader input = new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((response = input.readLine()) != null) {
                    JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
                    totalpages = convertedObject.get("total_pages").getAsInt();
                    JsonArray data = convertedObject.getAsJsonArray("data");
                    for (int i = 0; i < data.size(); i++) {
                        String title = data.get(i).getAsJsonObject().get("Title").getAsString();
                        titles.add(title);
                    }
                }
                input.close();
                page++;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        Collections.sort(titles);
        return titles.toArray(new String[0]);
    }
}
