# Coding Challenge 3    

## Programming

This code was written in Java. It could have been done in a simpler scripting 
language, but Java is what I'm most familiar with and could build it fastest. 
Further, I used Maven for compilation and assembly of the application and its 
dependent JARs into a single "uber JAR". 

If you're not familiar with the layout of a Maven project, you'll find the source
code under the `src/main/java` folder. There, you'll find the package 
`org.gengler.codingchallenge3` where the implementation code exists.

I wasn't sure if you wanted me to implement the CSV parsing or not. Since I've
done CSV parsing for several projects in the past, I opted to use a library I've
used in the past: OpenCSV. Also, Java provides simple ways to sort arrays which 
I also used. So, my first implementation was a simple procedure implementation 
that used OpenCSV and array sorting. But, this implementation does not really 
demonstrate much programming skill. Nor is it unit testable, in my opinion.

So, I broke up the functionality into three classes. And, while the implementations
of these classes still just use OpenCSV and array sorting, I think it demonstrates
more programming skills and is unit testable.

Also, I added the unasked for "feature" of removing blank strings from the input
just to add _something_ additional to the unit tests.

If you're concerned about the number of packages that are downloaded into the build
container, understand that _many_ of them are for the Maven build plug-in (such as
creating the "uber JAR" and will not be part of the application itself. The application
JAR (which contains my code, OpenCSV, and OpenCSV's dependencies) is only about 2.6MB.