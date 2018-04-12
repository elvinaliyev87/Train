import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestApp {

	private Town a;
	private Town b;
	private Town c;
	private Town d;
	private Town e;
	@Before
	public void before(){
	  a = new Town("A");
      b = new Town("B");
      c = new Town("C");
      d = new Town("D");
      e = new Town("E");
      Solution._route.put(a, new Node(a,b,5).next(new Node(a,d,5).next(new Node(a,e,7))));
      Solution._route.put(b, new Node(b,c,4));
      Solution._route.put(c, new Node(c,d,8).next(new Node(c,e,2)));
      Solution._route.put(d, new Node(d,c,8).next(new Node(d,e,6)));
      Solution._route.put(e, new Node(e,b,3));

	}
	@Test
	public void testDistanceABC(){
	    ArrayList<Town> routesList = new ArrayList<Town>();
	    routesList.add(a);
	    routesList.add(b);
	    routesList.add(c);
	    int actual = Solution.findDistance(routesList);
	    int expected=9;
	    Assert.assertEquals("Invalid result",expected, actual);
	}
	@Test
	public void testDistanceAD(){
	    ArrayList<Town> routesList = new ArrayList<Town>();
	    routesList.add(a);
	    routesList.add(d);
	    int actual = Solution.findDistance(routesList);
	    int expected=5;
	    Assert.assertEquals("Invalid result",expected, actual);
	}
	@Test
	public void testDistanceADC(){
	    ArrayList<Town> routesList = new ArrayList<Town>();
	    routesList.add(a);
	    routesList.add(d);
	    routesList.add(c);
	   int actual = Solution.findDistance(routesList);
	    int expected=13;
	    Assert.assertEquals("Invalid result",expected, actual);
	}
	@Test
	public void testDistanceAEBCD(){
	    ArrayList<Town> routesList = new ArrayList<Town>();
	    routesList.add(a);
	    routesList.add(e);
	    routesList.add(b);
	    routesList.add(c);
	    routesList.add(d);
	    int actual = Solution.findDistance(routesList);
	    int expected=22;
	    Assert.assertEquals("Invalid result",expected, actual);
	}
	@Test
	public void testDistanceAED(){
	    ArrayList<Town> routesList = new ArrayList<Town>();
	    routesList.add(a);
	    routesList.add(e);
	    routesList.add(d);
	    int actual = Solution.findDistance(routesList);
	    int expected=-1;
	    Assert.assertEquals("Invalid result",expected, actual);
	}

	@Test
	public void testNumberOfStopsBetweenCC(){
		int actual=Solution.numberOfTripsWithMaximumStop(c,c,3);
		int expected=2;
		 Assert.assertEquals("Invalid result",expected, actual);
	}
	@Test
	public void testNumberOfTripsStopsBetweenAC(){
		int actual=Solution.numberOfTripsWithMaximumStop(a,c,4);
		int expected=3;
		 Assert.assertEquals("Invalid result",expected, actual);
	}
	@Test
	public void testLengthShortestRouteBetweenAC(){
		int actual=Solution.lengthOfShortestRoute(a,c);
		int expected=9;
		 Assert.assertEquals("Invalid result",expected, actual);
	}
	@Test
	public void testLengthShortestRouteBetweenBB(){
		int actual=Solution.lengthOfShortestRoute(b,b);
		int expected=9;
		 Assert.assertEquals("Invalid result",expected, actual);
	}
	@Test
	public void testNumberOfDifferentRoutes(){
		int actual=Solution.numberOfDifferentRoutes(c,c,30);
		int expected=7;
		 Assert.assertEquals("Invalid result",expected, actual);
	}

}
