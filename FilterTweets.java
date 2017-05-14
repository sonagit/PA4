public class FilterTweets {
  /**
  * Constructor for main
  *
  * @param args command line arguments
  */
  public static void main(String[] args) {
    
    DateTime queryDT;
    TweetList t = new SampleTweets().t;

    // For starting and ending HTML string output
    String htmlStart = "<html>\n<head>\n<meta charset='utf8'>\n <link rel=\"stylesheet\" type=\"text/css\" href=\"tweetstyle.css\">\n</head>\n<body>\n";
    String htmlEnd = "\n</body>\n</html>\n";

    if(args.length == 0) {
      System.out.println("Please provide a command: \n");
      System.out.println("java FilterTweets <command> <criterion> <value>\n");
    }
    // Print out HTML
    else if(args.length > 0 && args[0]=="html") {
      System.out.println(htmlStart);
      System.out.println("Hi I'm a wizard");
      System.out.println(htmlEnd);
    }
    // Print out number
    else if(args.length > 0 && args[0]=="count") {
      System.out.println("THIS MANY\n*Holds up hands with fingers*");
    } //*/
    else {
    System.out.println("Incorrect command. Please use the following syntax: \n");
    System.out.println("java FilterTweets <command> <criterion> <value>\n");
    }
  }
}

