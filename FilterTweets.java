public class FilterTweets {
  /**
  * Constructor for main
  *
  * @param args command line arguments
  */
  public static void main(String[] args) {
    
    DateTime queryDT;
//    TweetList t = new SampleTweets().t;

    // These are the beginning and end of the HTML string you should print out.
    // Print htmlStart before printing the HTML produced from a list of tweets,
    // and htmlEnd after
    String htmlStart = "<html>\n<head>\n<meta charset='utf8'>\n <link rel=\"stylesheet\" type=\"text/css\" href=\"tweetstyle.css\">\n</head>\n<body> ";
    String htmlEnd = "</body>\n</html>";

    // Below here, you will add code to inspect the arguments and use the other
    // classes to print out the result of the given commands
    System.out.println(args[0]);
  }
}
