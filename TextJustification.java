import java.util.ArrayList;
import java.util.List;

public class TextFormatter {
    public static List<String> justifyText(String[] wordsArray, int maxLineWidth) {
        List<String> formattedLines = new ArrayList<>();
        int totalWords = wordsArray.length;
        int currentIndex = 0;
        
        while (currentIndex < totalWords) {
            int totalChars = wordsArray[currentIndex].length();
            int lastWordIndex = currentIndex + 1;
            
            while (lastWordIndex < totalWords) {
                if (totalChars + 1 + wordsArray[lastWordIndex].length() > maxLineWidth) break;
                totalChars += 1 + wordsArray[lastWordIndex].length();
                lastWordIndex++;
            }
            
            StringBuilder lineBuilder = new StringBuilder();
            int numberOfGaps = lastWordIndex - currentIndex - 1;
            
            // If it's the last line or only one word in the line
            if (lastWordIndex == totalWords || numberOfGaps == 0) {
                for (int i = currentIndex; i < lastWordIndex; i++) {
                    lineBuilder.append(wordsArray[i]);
                    if (i != lastWordIndex - 1) lineBuilder.append(" ");
                }
                while (lineBuilder.length() < maxLineWidth) {
                    lineBuilder.append(" ");
                }
            } else {
                int spaceSize = (maxLineWidth - totalChars) / numberOfGaps;
                int extraSpaces = (maxLineWidth - totalChars) % numberOfGaps;
                
                for (int i = currentIndex; i < lastWordIndex - 1; i++) {
                    lineBuilder.append(wordsArray[i]);
                    lineBuilder.append(" ");
                    for (int j = 0; j < spaceSize; j++) {
                        lineBuilder.append(" ");
                    }
                    if (extraSpaces > 0) {
                        lineBuilder.append(" ");
                        extraSpaces--;
                    }
                }
                lineBuilder.append(wordsArray[lastWordIndex - 1]); // Last word in the line
            }
            
            formattedLines.add(lineBuilder.toString());
            currentIndex = lastWordIndex;
        }
        
        return formattedLines;
    }
    
    public static void main(String[] args) {
        String[] wordsArray = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxLineWidth = 16;
        List<String> justifiedText = justifyText(wordsArray, maxLineWidth);
        
        for (String line : justifiedText) {
            System.out.println("\"" + line + "\"");
        }
    }
}
