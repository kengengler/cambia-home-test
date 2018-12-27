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
