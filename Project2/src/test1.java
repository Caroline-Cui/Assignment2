import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedList;

public class test1 {
    @Test
    public void Test_addEdge1() {
        FindPath g = new FindPath();
        g.addActor(new LinkedList<>(Arrays.asList(new String[]{"A", "B"})));
        g.addActor(new LinkedList<>(Arrays.asList(new String[]{"C", "D"})));
        g.addActor(new LinkedList<>(Arrays.asList(new String[]{"A", "B", "C"})));
        g.addActor(new LinkedList<>(Arrays.asList(new String[]{"A", "O", "C"})));
        g.addActor(new LinkedList<>(Arrays.asList(new String[]{"P", "L", "C"})));
//    }
//    @Test
//    public void Test_inFindPath1(){
//        FindPath g = new FindPath();
//        g.addActor(new LinkedList<>( Arrays.asList(new String[] {"A", "B"})));
//        g.addActor(new LinkedList<>( Arrays.asList(new String[]{"C", "D"})));
//        g.addActor(new LinkedList<>( Arrays.asList(new String[]{"A", "B", "C"})));        Assert.assertEquals(true, g.inFindPath("A"));
//        Assert.assertEquals(true, g.inFindPath("B"));
//        Assert.assertEquals(true, g.inFindPath("C"));
//        Assert.assertEquals(true, g.inFindPath("D"));
//        Assert.assertEquals(false, g.inFindPath("E"));

    }

    @Test
    public void Test_findShortestRoute1() throws Exception {
        FindPath g = new FindPath();
        g.addActor(new LinkedList<>(Arrays.asList(new String[]{"A", "B"})));
        g.addActor(new LinkedList<>(Arrays.asList(new String[]{"C", "D"})));
        g.addActor(new LinkedList<>(Arrays.asList(new String[]{"A", "B", "C"})));

        Assert.assertEquals(Arrays.asList(new String[]{"D", "C", "A"}), g.shortestPath("A", "D"));
        Assert.assertEquals(Arrays.asList(new String[]{"A", "B"}), g.shortestPath("B", "A"));
        Assert.assertEquals(Arrays.asList(new String[]{"D", "C", "B"}), g.shortestPath("B", "D"));
    }
}
//    @Test
//    public void Test_addEdge2(){
//        FindPath g = new TableFindPath();
//        g.addActor(new String[]{"A", "B"});
//        g.addActor(new String[]{"C", "D"});
//        g.addActor(new String[]{"A", "B", "C"});
//    }
//    @Test
//    public void Test_inFindPath2(){
//        FindPath g = new TableFindPath();
//        g.addActor(new String[]{"A", "B"});
//        g.addActor(new String[]{"C", "D"});
//        g.addActor(new String[]{"A", "B", "C"});
//        Assert.assertEquals(true, g.inFindPath("A"));
//        Assert.assertEquals(true, g.inFindPath("B"));
//        Assert.assertEquals(true, g.inFindPath("C"));
//        Assert.assertEquals(true, g.inFindPath("D"));
//        Assert.assertEquals(false, g.inFindPath("E"));
//
//    }
//    @Test
//    public void Test_findShortestRoute2() throws Exception {
//        FindPath g = new TableFindPath();
//        g.addActor(new String[]{"A", "B"});
//        g.addActor(new String[]{"C", "D"});
//        g.addActor(new String[]{"A", "B", "C"});
//        Assert.assertEquals(Arrays.asList(new String[]{"D", "C", "A"}),g.findShortestRoute("A","D"));
//        Assert.assertEquals(Arrays.asList(new String[]{"A", "B"}),g.findShortestRoute("B","A"));
//        Assert.assertEquals(Arrays.asList(new String[]{"D", "C", "B"}),g.findShortestRoute("B","D"));
//    }
//    @Test
//    public void Test_format_name() {
//        CS245A2 t = new CS245A2();
//        Assert.assertEquals("Wei Tian", t.formatName("wei tian"));
//    }
//}