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

    // Ignore calls without options
    if(args.length == 0) {
      System.out.println("Please provide a command: \n");
      System.out.println("java FilterTweets <command> <criterion> <value>\n");
    }
    
    // Print out HTML
    else if( args.length > 0 && args[0].equals("html") ) {
      // Print starting HTML
      System.out.println(htmlStart);
      
      // User queries
      if( args[1].equals("user") ) {
        UserQuery uq = new UserQuery(args[2]);
        System.out.println(t.filter(uq).toHTML());
      }

      // before queries
      if( args[1].equals("before") ) {
        String[] dt = args[2].split("/");
        int d = Integer.parseInt(dt[0]);
        int m = Integer.parseInt(dt[1]);
        int y = Integer.parseInt(dt[2]);
//
	System.out.println(new DateTime(d,m,y).toHTML());
//        BeforeQuery bq = new BeforeQuery(new DateTime(d,m,y));
//        System.out.println(t.filter(bq).toHTML());
      }

      // Print end HTML
      System.out.println(htmlEnd);
    }
    
    // Print out number
    else if(args.length > 0 && args[0].equals("count")) {
      System.out.println("THIS MANY\n*Holds up hands with fingers*");
    } //*/
    else {
    System.out.println("Incorrect command. Please use the following syntax: \n");
    System.out.println("java FilterTweets <command> <criterion> <value>\n");
    }
  }
}
