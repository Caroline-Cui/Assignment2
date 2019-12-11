import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class test
{
    public static void main(String[] args) {
//        String str = "{cast_id: 242, character: Jake Sully, credit_id: 5602a8a7c3a3685532001c9a, gender: 2, id: 65731, name: Sam Worthington, order: 0}";
//        JSONParser parser = new JSONParser();
//
//        try {
//            JSONArray json = (JSONArray) parser.parse(str);
//        } catch (ParseException e) {
//            System.out.println("invaid!!!");
//        }
        ArrayList<String> seen = new ArrayList<>();
        seen.add("A");
        seen.add("B");
        seen.add("C");
        seen.add("D");
        seen.add("E");
        seen.add("G");
        seen.add("E");
        seen.add("H");
        ArrayList<String> path = new ArrayList<>();
        path.add("A");
        path.add("A");
        path.add("A");
        path.add("A");
        path.add("A");
        path.add("B");
        path.add("E");
        path.add("D");
        String find = "G";
        String input = "A";
//        ArrayList<String> output = new ArrayList<>();
        String[] output = new String[10];
        String current = find;
        int i = 0;
        while (current != input)
        {
            int index = seen.indexOf(current);
            String p = path.get(index);
//            output.add(p);
            output[i] = p;
            current = p;
            i++;
        }
        for (int a = 0; a < output.length; a++)
        {
            System.out.println(output[a]);
        }

        Hashtable<String, String> table = new Hashtable<>();
        table.put("a", "a");
        table.put("b", "b");
        table.put("c", "c");
        table.put("d", "d");
        table.replace("a", "o");
        table.toString();
        System.out.println(table);

    }
}
