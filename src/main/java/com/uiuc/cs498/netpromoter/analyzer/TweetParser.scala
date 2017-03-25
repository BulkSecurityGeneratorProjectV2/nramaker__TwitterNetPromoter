package com.uiuc.cs498.netpromoter.analyzer

import org.apache.spark.mllib.linalg.Vector
import org.apache.spark.mllib.feature.HashingTF

object TweetParser {
  
  val stopwords = List[String]("i","me","my","myself","we","our","ours","ourselves","you","your","yours","yourself","yourselves","he","him",
      "his","himself","she","her","hers","herself","it","its","itself","hey","them","their","theirs","themselves","what","which","who","whom",
      "this","that","these","those","am","is","are","was","were","be","been","being","have","has","had","having","do","does","did","doing",
      "a","an","the","and","but","if","or","because","as","until","while","of","at","by","for","with","about","against","between","into",
      "through","during","before","after","above","below","to","from","up","down","in","out","on","off","over","under","again","further",
      "then","once","here","there","when","where","why","how","all","any","both","each","few","more","most","other","some","such","no",
      "nor","not","only","own","same","so","than","too","very","s","t","can","will","just","don","should","now")
      
  def cleanAndTokenizeTweet(text: String): Seq[String] = {
    text.toLowerCase()
      .replaceAll("@\\w+", "")
      .replaceAll("#\\w+", "")
      .split("\\s")
      .filter(_.matches("^[a-zA-Z]+$"))
      .filter(!stopwords.contains(_))
  }
  
  def generateWordCountVector(tweetTokens: Seq[String]): Vector = {
     var vectorGenerator = new HashingTF()
     vectorGenerator.transform(tweetTokens)
  }
}