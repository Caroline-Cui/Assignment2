//import java.util.ArrayList;
//import java.util.Hashtable;
//import java.util.LinkedList;
//
//public class a {
//}
//
//    public String[] shortestPath(String input, String finding) throws Exception {
////        System.out.println(actors.containsKey("D"));
//        if (!actors.containsKey(input) || !actors.containsKey(finding))
//            throw new Exception();
//        // elements represents all nodes in the list which is ready to be process
//        LinkedList<String> elements = new LinkedList<>();
//        // check if the key has been visited
//        ArrayList<String> seen = new ArrayList<>();
//        // create an output string, ready to add elements
//        String[] outputs = new String[10];
//        // value of the parameter as a key
//        LinkedList<String> inputValue = actors.get(input);
//        // previous path of a particular node
//        ArrayList<String> path = new ArrayList<>();
//        // String that is current visiting
//        String current = null;
//        Hashtable<String,String> table = new Hashtable<>();
//
//        // add the first element
//        elements.add(input);
//        // add input values
////        for (int i = 0; i < inputValue.size(); i++)
////        {
////            elements.add(inputValue.get(i));
//////            path.add(input);
////        }
//        path.add(input);
////        table.put(input, input);
//        // when the element list is not empty
//        while (!elements.isEmpty())
//        {
//            // poll the first element out from the sting
//            current = elements.poll();
//            // store the value for the processing element
//            LinkedList<String> currValue = actors.get(current);
//            if (!seen.contains(current)) {
//                seen.add(current);
//                table.put(input, input);
//                // add all adjacent elements into the element list
//                for (int i = 0; i < currValue.size(); i++) {
//                    if (!seen.contains(currValue.get(i)))
//                    {
//                        if (! elements.contains(currValue.get(i)))
//                        {
//                            path.add(current);
////                            table.replace(, current);
//                        }
//
//
//                        elements.add(currValue.get(i));
//                    }
//                }
//            }
//            if (current == finding)
////                check = 1;
//                break;
//        }
//        String temp = finding;
//        int o = 0;
//        outputs[o] = temp;
//        while (temp != input)
//        {
//            o++;
//            int index = seen.indexOf(temp);
////            System.out.println(temp);
////            System.out.println(index);
//            String p = path.get(index);
////            System.out.println(o);
//            outputs[o] = p;
//            temp = p;
//        }
////        outputs[o+1] = input;
//        return outputs;
//    }
