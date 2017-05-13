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
  TweetList filter(IQuery q) {
    //blah
  }

  /**
   * Returns the number of tweets matching the given query
   *
   * @param q
   * @return int
   */
  int count(IQuery q) {
    //blah
  }

  /**
   * Returns the number of tweets in the list
   *
   * @param none
   * @return string
   */
  int length() {
    //blah
  }
  
 /**
   * Returns a String containing the toHTML of all tweets in the list
   * concatenated together in order.
   *
   * @param none
   * @return string
   */
  String toHTML() {
    //blah
  }
}

/******************************************************************************
 * This class represents a tweet in a list, along with the list of other tweets.
 *
 *****************************************************************************/
class TLEmpty implements TweetList{
  TLEmpty(){ }
  
  /**
   * Returns the base case
   *
   * @param q an IQuery
   * @return TweetList
   */
  TweetList filter(IQuery q) {
    //blah
  }

  /**
   * Returns the base case
   *
   * @param q
   * @return int
   */
  int count(IQuery q) {
    return 0;
  }

  /**
   * Returns the base case
   *
   * @param none
   * @return string
   */
  int length() {
    return 0;
  }
  
 /**
   * Returns the base case
   *
   * @param none
   * @return string
   */
  String toHTML() {
    //blah
  }
}
}
