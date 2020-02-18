package sample.Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sample.domains.User;

import java.util.Iterator;

public class JSONParsing {
    public static void getUser (String json) throws ParseException {
        Object user = new JSONParser().parse(json);
        JSONObject jsonObject = (JSONObject) user;
        String name = (String) jsonObject.get("secretBase");
        JSONArray array = (JSONArray) jsonObject.get("members");
        Iterator<?> members = array.iterator();
        int i = 0;
        while (members.hasNext()) {
            i++;
            JSONObject member = (JSONObject) members.next();
            System.out.println("Учатник номер " + i + ", имя - " + member.get("name") + ", возраст - " + member.get("age") + ", настоящее имя " +
                    member.get("secretIdentity") + "Секретные способности");
            JSONArray powersOb = (JSONArray) member.get("powers");
            Iterator<?> powers = powersOb.iterator();
            int j = 0;
            while (powers.hasNext()) {
                String power = (String) powers.next();
                System.out.println(power);
                i++;
            }
        }
    }
}
