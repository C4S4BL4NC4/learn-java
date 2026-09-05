import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");

//        System.out.println("------------------------------");
//
//        var sentence = "I love motorcycles.";
//        var matched = Pattern.matches("[A-Z].*\\.", sentence);
//        System.out.println(sentence + " = " + matched);
//
//        System.out.println("------------------------------");
//
//        Pattern firstPattern = Pattern.compile("[A-Z].*\\.");
//        var matcher = firstPattern.matcher(sentence);
//        System.out.println(sentence + " = " + matcher.matches());
//
//        System.out.println("------------------------------");
//
//        String htmlSnippet = """
//                <H1>My Heading</H1>
//                <h2>Sub-Heading</h2>
//                <p>This is a paragraph about something.</p>
//                <p>This is another paragraph about something else.</p>
//                <h3>Summary</h3>
//                """;
//
//        Pattern htmlPattern = Pattern.compile("<[hH]\\d>(.*)</[hH]\\d>");
//        Matcher htmlMatcher = htmlPattern.matcher(htmlSnippet);
//
//        while (htmlMatcher.find()) {
//            System.out.println("Group: " + htmlMatcher.group());
//            System.out.println("Group0: " + htmlMatcher.group(0));
//            System.out.println("Group1: " + htmlMatcher.group(1));
//
//        }

        System.out.println("------------------------------");

        String phoneList = """
                (800) 123-4567
                (800)123-4567
                (800) 123 4567
                800-123-4567
                800 123-4567
                800 123 4567
                8001234567
                """;
        Pattern phonePattern = Pattern.compile("\\(*[0-9]{3}[)\\s-]*\\d{3}[\\s-]*\\p{Digit}{4}");
        Matcher phoneMatcher = phonePattern.matcher(phoneList);
        phoneMatcher.results().forEach(mr -> System.out.println(mr.group()));

        System.out.println("------------------------------");

        String htmlSnippet = """
                    <H1>My Header</H1>
                    <h2>Sub-heading</h2>
                    <p>This is a paragraph about something.</p>
                    <p style="abc">This paragraph is about something else.</p>
                    <h3 id="third">Summary</h3>
                    <br/>
                    <p>Testing</p>
                """;

//        Pattern htmlPattern = Pattern.compile("<(\\w+)[^>]*>([^\\v</>]*)(</\\1>)*");
//        Matcher htmlMatcher = htmlPattern.matcher(htmlSnippet);
//        htmlMatcher.results().forEach(mr -> System.out.println("Full tag: " + mr.group() +
//                "\n" + "Type: " + mr.group(1) +
//                "\n" + "Content: " + mr.group(2) +
//                "\n" + "Summary: " + mr.group(3) +
//                "\n" + "-------------------------"
//        ));

        String emails = """
                john.boy@valid.com
                jane.doe-smith@valid.co.uk
                john.boy@invalid
                bob!@invalid.com
                jane_Doe1976@valid.co.uk
                elaineinvalid1983@.com
                david@invalid..com
                bob-1964@valid.net
                elaine@valid-test.com.au
                david@valid.io
                davidvalid.io
                @coldfeet.comanyinvalid
                """;
        
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9._-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}$",
                Pattern.MULTILINE);
        Matcher emailMatcher = emailPattern.matcher(emails);
        emailMatcher.results().forEach(mr -> System.out.println(mr.group()));


    }
}
