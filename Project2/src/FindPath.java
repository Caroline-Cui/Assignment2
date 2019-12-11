import org.w3c.dom.Node;

import java.util.*;

public class FindPath
{
    Hashtable<String, LinkedList<String>> actors;
    public FindPath()
    {
        actors = new Hashtable<>();
    }

    public void addActor(LinkedList<String> movieActor)
    {
        for (int i = 0; i < movieActor.size(); i++)
        {
            String currentActor = movieActor.get(i).toLowerCase();
            // store value for current actor
            LinkedList<String> value = actors.get(currentActor);
            // check if the actors hashtable is empty
            if (actors == null)
            {
                actors.put(currentActor, movieActor);
            }
            if (!actors.containsKey(currentActor))
            {
                actors.put(currentActor, new LinkedList<>(movieActor));
                actors.get(currentActor).remove(currentActor);
            }
            // hit else statement means currentActor is already exist in the hashtable
            else
            {
                // check if value of the actor dose not have any of the actor in the actor list.
                // if no -> add the actor into his value list.
                // loop through the movieActor list to find if the key mach but
                // some elements in the list doesn't exist in the value
                for (int j = 0; j < movieActor.size(); j++)
                {
                    // check if value doesn't contain the actor that we are looking for
                    // this person doesn't exit in the value && he is not key
//                    System.out.println("Mo: "+movieActor);
//                    System.out.println(""+j+": "+movieActor.get(j));
//                    System.out.println(value.contains(currentActor));
                    if ( !value.contains(currentActor) && !movieActor.get(j).equals(currentActor)
                    && !value.contains(movieActor.get(j)))
                    {
                        value.add(movieActor.get(j));
                    }
                }
            }
        }
    }

    public ArrayList<String> shortestPath(String input, String finding) throws Exception {
        LinkedList<String> elements = new LinkedList<>();
//        ArrayList<String> seen = new ArrayList<>();
        ArrayList<String> outputs = new ArrayList<>();
        LinkedList<String> currValue;
//        LinkedList<String> inputValue = actors.get(input);
//        ArrayList<String> path = new ArrayList<>();
//        System.out.println(actors.containsKey(input));
//        System.out.println(actors.containsKey(finding));
//        System.out.println(input);
        if (!actors.containsKey(input.toLowerCase()) || !actors.containsKey(finding.toLowerCase()))
            throw new Exception("Invalid");
        String current = null;
        Hashtable<String,String> table = new Hashtable<>();
        String p = "";
        String s = "";
        elements.add(input);
//        path.add(input);
        p = input;
        while (!elements.isEmpty())
        {
            current = elements.poll();
            currValue = actors.get(current.toLowerCase());
            if (current.toLowerCase().equals(finding.toLowerCase()))
            {

                String temp = current;
                while (!temp.equals(input))
                {
                    outputs.add(temp);
                    temp = table.get(temp);
                }
                outputs.add(input);
//                outputs.add(finding);
                break;
            }
//            if (!table.containsKey(current)) {
//                seen.add(current);
            s = current;
            for (int i = 0; i < currValue.size(); i++)
            {
                String neibour = currValue.get(i);
                if (!table.containsKey(neibour))
                {
//                   System.out.println(elements.size());
//                   if (! elements.contains(neibour))
//                        {
//                            path.add(current);
//                            p = current;
//                            s = neibour;
//                        }
                    table.put(neibour, s);
                    elements.add(neibour);
                }
//                    table.put(s,p);
//                }
            }
        }
//        System.out.println(current.toLowerCase());
//        System.out.println(finding.toLowerCase());
        return outputs;
    }
}
