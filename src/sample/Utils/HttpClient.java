package sample.Utils;

import org.json.simple.parser.ParseException;
import sample.domains.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public void readUserInfo() throws IOException, ParseException {
        String requestUrl = "https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json";

        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.connect();

        InputStream in;
        int status = connection.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            in = connection.getErrorStream();
        } else {
            in = connection.getInputStream();
        }

        String response = convertStreamToString(in);
        JSONParsing.getUser(response);
    }

    private String convertStreamToString(InputStream stream) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        stream.close();

        return sb.toString();
    }



}
