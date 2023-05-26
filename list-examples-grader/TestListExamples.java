import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StringCheck implements StringChecker {
  
  String filter_string = "moon";

  public StringCheck(String filter){
    this.filter_string = filter;
  }

  public boolean checkString(String s){
    if (s.contains(filter_string)){return true;}
    return false;
  }
}

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMerge_differentLengths() {
    List<String> left = Arrays.asList("Cheetos", "Goldfish", "Cheeseits");
    List<String> right = Arrays.asList("Donald");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("Cheeseits", "Cheetos", "Donald", "Goldfish");
    assertEquals(expected, merged);
  }
  @Test(timeout = 500)
  public void testMerge_differentLength2() {
    List<String> right = Arrays.asList("Cheetos", "Goldfish", "Cheeseits");
    List<String> left = Arrays.asList("Donald");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("Cheeseits", "Cheetos", "Donald", "Goldfish");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMerge_capitalization() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("A", "B", "C");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("A", "B", "C", "a", "b", "c");
    assertEquals(expected, merged);
  }
  @Test(timeout = 500)
  public void testMerge_duplicates() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "b", "b");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "b", "b", "c");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilter(){
    StringChecker sc = new IsMoon();
    List<String> data = new ArrayList<String>();
    data.add(0, "moon");
    data.add(1, "GARBAGE");
    data.add(0, "moon");
    List<String> expected = Arrays.asList("moon", "moon");
    List<String> result = ListExamples.filter(data, sc);
    assertEquals(expected, result);
    

  }
}

// hello world
