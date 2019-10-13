package TextClassifiction;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * A Java implementation of TF_IDF. /Stands for Term Frequency-Inverse Document Frequency
 * the ti_idf weight is a weight often used in information retrieval and text mining. The weight is a statistical
 * measure used to evaluate how important a word is to a document in a corpus./
 * For more information visit: http://www.tfidf.com/ - or even Wikipedia
 *
 * If you discover any improvements that can be made please feel free to raise and/or fix :)
 *
 * @author andyjk15
 */

public class TFIDF {

    Pattern chars       = Pattern.compile("[^\\w\\s]");
    Pattern underscore  = Pattern.compile("_");
    Pattern whitespace  = Pattern.compile("\\s+");

    public static String Match(Matcher matcher, String message) {
        while(matcher.find())
        {
            String s = match.group();
            return message.replaceAll("\\"+s, "");
        }
    }

    public static String Sanatise(String message) {
        Matcher strippedChars = chars.matcher(message);
        message = match(strippedChars, message);

        Matcher strippedUnderscore = underscore.matcher(message);
        message = match(strippedUnderscore, message);

        Matcher strippedWhitespace = whitespace.matcher(message);
        message = match(strippedWhitespace, message);

        message = message.trim();

        return message;
    }

    public static String TokeniseToSentences(String message) {
        String[] sentTokens = message.split(".");
        return sentTokens;
    }

    public static String TokeniseToWords(String message) {
        String[] wordTokens = message.split(" ");
        return wordTokens;
    }

    public static int countWords(String message) {
        int count = 0;
        String[] words = TokeniseToWords(message);
        for (int index : words) {
            count += 1;
        }
        return count;
    }

    public static Hashmap<HashMap<String, byte>, HashMap<String, byte>> getDocument(String message) {
        HashMap<HashMap<String, byte>, HashMap<String, byte>> documentInformation = new HashMap<HashMap<String, byte>, HashMap<String, byte>>();
        HashMap<String, byte> documentId = new HashMap<String, byte>();
        HashMap<String, byte> documentCount = new HashMap<String, byte>();

        for (int index : message) {
            count = countWords(message);
            documentId.put("doc_id", index);
            documentCount.put("doc_count", count);

            documentInformation.put(documentId.get("doc_id"), documentCount.get("doc_count"));
            documentId.clear();
            documentCount.clear();
        }
        return documentInformation;
    }

    public static Hashmap<HashMap<String, byte>, HashMap<String, byte>> getDocument(String message) {
        
    }

    public static void main(String[] args) {
        String document = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a " +
                "piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, " +
                "a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure " +
                "Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in " +
                "classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 " +
                "and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written " +
                "in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. " +
                "The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.";

        documentInSentences = TokeniseToSentences(document);

        String[] documentInSentencesCleaned;
        for (int index : documentInSentences) {
            documentInSentencesCleaned[index] = Sanatise(documentInSentences[index]);
        }

        documentInfo = getDocument(documentInSentencesCleaned);


    }
}