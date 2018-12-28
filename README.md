# Cambia Home Test

## Programming

This code was written in Java. It could have been done in a simpler scripting 
language, but Java is what I'm most familiar with and could build it fastest. 
Further, I used Maven for compilation and assembly of the application and its 
dependent JARs into a single "uber JAR".

If you're not familiar with the layout of a Maven project, you'll find the source
code under the `src/main/java` folder. There, you'll find the package 
`org.gengler.cambiahometest` where the implementation code exists.

I wasn't sure if you wanted me to implement the CSV parsing or not. Since I've
done CSV parsing for several projects in the past, I opted to use a library I've
used in the past: OpenCSV. Also, Java provides simple ways to sort arrays which 
I also used. So, my first implementation was a simple procedure implementation 
that used OpenCSV and array sorting. But, this implementation doesn't really 
demonstrate much programming skill. Nor is it unit testable, in my opinion.

So, I broke up the functionality into three classes. And, while the implementations
of these classes still just use OpenCSV and array sorting, I think it demonstrates
more programming skills and is unit testable.

Also, I added the unasked for "feature" of removing blank strings from the input
just to add _something_ additional to the unit tests.

## Gherkin

### Tests

>**Scenario**: Output incoming strings in descending alphabetical order.  
Given the input file (input.csv) contains "Chicago,New York,London,Springfield"  
When the application is run  
Then the application terminates normally and output file (output.csv) contains "Springfield,New York,London,Chicago"

>**Scenario**: Input contains blank strings  
Given the input file (input.csv) contain Chicago,,New York,   ,London,Springfield"  
When the application is run  
Then the application terminates normally and output file (output.csv) contains "Springfield,New York,London,Chicago"

>**Scenario**: Input file does not exist  
Given the input file does not exist
When the application is run  
Then the application terminates with a negative return code and a message explaining that the input file did not exist

>**Scenario**: Input file is empty  
Given the input file is empty
When the application is run  
Then the application terminates normally and output file is empty

## Tools

### Version Control Systems

### Docker Pros/Cons

### Language Choice

## Testing Methodology

### Role for QA

### Two Weeks

### When to Use Automated Testing

### What _Not_ to Test
