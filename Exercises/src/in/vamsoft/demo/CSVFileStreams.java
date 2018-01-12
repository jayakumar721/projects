package in.vamsoft.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVFileStreams {

  public static void main(String[] args) {
    
    try(Stream<String> file = Files.lines(Paths.get("SampleCSVFile.csv"),StandardCharsets.ISO_8859_1)) {
      List<List<String>> lines = file.filter(line->line.startsWith("8")).map(line->Arrays.asList(line.split(","))).collect(Collectors.toList());
      lines.forEach(line->System.out.println(line));
      
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
}
