import org.w3c.dom.Node;

import java.util.*;

public class assign2
{
    Hashtable<String, LinkedList<String>> actors;
    public assign2()
    {
        actors = new Hashtable<>();
    }

    public void addActor(LinkedList<String> movieActor)
    {
        for (int i = 0; i < movieActor.size(); i++)
        {
            String currentActor = movieActor.get(i);
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

    public String[] shortestPath(String input, String finding) throws Exception {
        if (!actors.containsKey(input) || !actors.containsKey(finding))
            throw new Exception();
        LinkedList<String> elements = new LinkedList<>();
        ArrayList<String> seen = new ArrayList<>();
        String[] outputs = new String[10];
//        LinkedList<String> inputValue = actors.get(input);
        ArrayList<String> path = new ArrayList<>();
        String current;
        Hashtable<String,String> table = new Hashtable<>();
        String p = "";
        String s = "";
        elements.add(input);
//        path.add(input);
        while (!elements.isEmpty())
        {
            current = elements.poll();
            LinkedList<String> currValue = actors.get(current);
            if (!table.containsKey(current)) {
//                seen.add(current);
                s = current;
//                table.put(input, input);
                for (int i = 0; i < currValue.size(); i++) {
                    if (!table.containsKey(currValue.get(i)))
                    {
                        if (! elements.contains(currValue.get(i)))
                        {
//                            path.add(current);
                            p = current;
                        }
                        elements.add(currValue.get(i));
                    }
                    table.put(s,p);
                }
            }
            if (current == finding)
                break;
        }
        String temp = finding;
        int o = 0;
        outputs[o] = temp;
        while (temp != input)
        {
            o++;
            temp = table.get(temp);
            outputs[o] = temp;
        }
//        String temp = finding;
//        int o = 0;
//        outputs[o] = temp;
////        while (temp != input)
////        {
////            o++;
////            int index = seen.indexOf(temp);
////            String p = path.get(index);
////            outputs[o] = p;
////            temp = p;
////        }
        return outputs;
    }
}
