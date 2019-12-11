import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Assignment2
{
    public static FindPath path = new FindPath();

    public static LinkedList<String> convertToJson(String row) throws ParseException {
        LinkedList<String> actorsPerMovie = new LinkedList<>();
//        System.out.println("Row");
//        System.out.println(row);
        if(row.contains("[]"))
            return null;
        String[] rowArr = row.split("\\[\\{");

//        for (int i = 0; i < rowArr.length; i++)
//            System.out.println(rowArr[i]);
        String firstRow = rowArr[1].replaceAll("\"\"", "\"");
//        System.out.println(firstRow);
//        System.out.println("HI");
//        System.out.println(firstRow);
//        String[] first = firstRow.split("},");
//        System.out.println(first[0]+"}");
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse("[{"+firstRow.substring(0,firstRow.length()-3));
        for (Object item :json)
        {
            JSONObject item1 = (JSONObject) item;
//            System.out.println();
            actorsPerMovie.add((String) item1.get("name"));
//            System.out.println(item1.get("name"));
        }

//        Object a = json.get("name");
//        if(name)
 //       System.out.println(a);

////        return json;
        return actorsPerMovie;
    }

//    public static void addToGraph(LinkedList<String> movieActors)
//    {
//        path.addActor(movieActors);
//    }

    public static void readFile(String fileName)
    {

        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));

            String row;
            row = csvReader.readLine();
            String[] subRow;
            LinkedList<String> jsonArr;
//            int i =0;
            while (row != null)
            {
//                i++;
                row = csvReader.readLine();
                if (row == null)
                    break;
                subRow = row.split(",", 3);
                jsonArr = convertToJson(subRow[2]);
//                System.out.println(jsonArr.toString());
                if (jsonArr != null)
                    path.addActor(jsonArr);


//                System.out.println(jsonArr);
//                System.out.println(i);
//                System.out.println("--------NEXTMOVIE---------");
//                System.out.println(subRow);

//                for(int i = 0; i < subRow.length; i++)
//                {
//                    System.out.println(subRow[i]);
//                }
//                break;
            }
//            System.out.println(path.actors.size());

        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Cannot find the file");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String[] userInput()
    {
        String[] names = new String[2];
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter first actor: ");
        String name1 = scan1.nextLine();
        names[0] = name1;
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Enter Second actor: ");
        String name2 = scan2.nextLine();
        names[1] = name2;
        return names;
    }


    public static void main(String[] args)  {
        readFile(args[0]);

        String[] names = userInput();
        ArrayList<String> output = null;
        try {
            output = path.shortestPath(names[0], names[1]);
            System.out.println("Path between "+names[0]+" and "+names[1]+ ": ");
            for (int i = 0; i < output.size(); i++)
            {
                System.out.print(output.get(i));
                if (i != output.size()-1)
                    System.out.print(" -> ");
                else
                    System.out.println("");
            }
        } catch (Exception e) {
            System.out.println("No Such Actor!");
        }

//        System.out.println(output);
//        for (int i = 0; i < output.size(); i++)
//            System.out.println(output.get(i));

    }
}
