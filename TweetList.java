/******************************************************************************
 * Interface for a linked list structure of Tweet
 *
 *****************************************************************************/
interface TweetList {

  /**
   * Filter the tweets according to the query passed in.
   *
   * @param q an abstract query for filtering tweets
   * @return a TweetList that has all the qualified tweets according to the query
   */
  TweetList filter(IQuery q);

  /**
   * Count the number of qualified tweets according to the query passed in.
   *
   * @param q an abstract query for filtering tweets
   * @return an int that represents the number of qualified tweets
   */
  int count(IQuery q);

  /**
   * Provide the HTML for all tweets in the list.
   *
   * @return a string that represents all HTML for all tweets
   */
  String toHTML();

  /**
   * Return the length of the list.
   *
   * @return an int that represents the length of the tweet list
   */
  int length();
}

/******************************************************************************
 * This class represents a tweet in a list, along with the list of other tweets.
 *
 *****************************************************************************/
class TLLink implements TweetList{

  ATweet tweet;
  TweetList rest;

  /**
   * Constructor for TLLink that initializes all fields
   *
   * @param tweet
   * @param rest
   */
  TLLink(ATweet tweet, TweetList rest){
    this.tweet = tweet;
    this.rest=rest;
  }

  /**
   * Returns a new TweetList with only the tweets matching the given query.
   * Should optionally check and include the value field in the resulting
   * list, along with recursively checking the rest of the list.
   *
   * @param q an IQuery
   * @return TweetList
   */
  public TweetList filter(IQuery q) {
    if(q.matches(this.tweet)) {
      return new TLLink(this.tweet, this.rest.filter(q));
    }
    else {
      return new TLEmpty();
    }
  }

  /**
   * Returns the number of tweets matching the given query
   *
   * @param q
   * @return int
   */
  public int count(IQuery q) {
    if(q.matches(this.tweet)) {
      return 1 + this.rest.count(q);
    }
    else {
      return 0;
    }
  }

  /**
   * Returns the number of tweets in the list
   *
   * @param none
   * @return string
   */
  public int length() {
    return 1 + this.rest.length();
  }
  
 /**
   * Returns a String containing the toHTML of all tweets in the list
   * concatenated together in order.
   *
   * @param none
   * @return string
   */
  public String toHTML() {
    return this.tweet.toHTML() + this.rest.toHTML();
  }
}

/******************************************************************************
 * This class represents a tweet in a list, along with the list of other tweets.
 *
 *****************************************************************************/
class TLEmpty implements TweetList{
  TLEmpty(){ }
  
  /**
   * Returns the base case: an empty list
   *
   * @param q an IQuery
   * @return TweetList
   */
  public TweetList filter(IQuery q) {
    return new TLEmpty();
  }

  /**
   * Returns the base case: 0
   *
   * @param q
   * @return int
   */
  public int count(IQuery q) {
    return 0;
  }

  /**
   * Returns the base case: 0
   *
   * @param none
   * @return string
   */
  public int length() {
    return 0;
  }
  
 /**
   * Returns the base case
   *
   * @param none
   * @return string
   */
  public String toHTML() {
    return " ";
  }
}
