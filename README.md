# Cambia Home Test

## Programming

This code was written in Java. It could have been done in a simpler scripting 
language, but Java is what I'm most familiar with and could build it fastest. 
Further, I used Maven for compilation and assembly of the application and its 
dependent JARs into a single "uber JAR".

If you're not familiar with the layout of a Maven project, you'll find the source
code under the `src/main/java` folder. There, you'll find the package 
`org.gengler.cambia.hometest` where the implementation code exists.

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

## Gherkin

### Tests

>**Scenario**: Output incoming strings in descending alphabetical order.  
Given the input file (input.csv) contains "Chicago,New York,London,Springfield"  
When the application is run  
Then the application terminates normally and output file (output.csv) contains "Springfield,New York,London,Chicago"

>**Scenario**: Input contains blank strings  
Given the input file (input.csv) contains Chicago,,New York,   ,London,Springfield"  
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

###Gherkin tests in the future
Gherkin tests make it easier for non-programmers to review test coverage against the
stated specification and determine if that application is meeting the specification. 
As the project ages, these tests remain important to ensure the coverage is maintained.
Take, for instance, my second test which requires that blanks be removed. In that stated
example input, the product owner can specify any notion of "blank" they wish to ensure is
removed. The test will then verify that all such blanks were, indeed removed.

I should also mention that it provides another variation on the specification by which
the requirements can be conveyed to the developer. The nice part about these test is that
_these_ requirements can actually be tested in the developers environment during development
rather than later in the development process.

## Tools

### Version Control Systems

In general, I find a VCS _very_ helpful for a number of reasons:
+ Backup: If you have a centralized VCS, code changes across time are stored (and hopefully
archived) on a dependable server external to the developer's machine. Granted, the changes
have to make it to the VCS server, but once there, they are preserved.
+ History: If a code change breaks functionality, the VCS can help in the investigation into
the specific change that introduced the failure.
+ Recovery: If a code change breaks functionality, the VCS makes it easier to "roll-back" to
a previous version of the code that works. And, depending on the complexity of the VCS, you
may be able to roll-back specific commits and surgically remove changes that introduced 
failures.
+ Process: Depending on the VCS, the VCS can enforce development processes including
code reviews and approvals before changes are accepted into mainlines and branches shared
with other developers. 
+ Communication: Again, depending on the VCS and the processes in place, the VCS can facilitate
communication between developers/QA about how the code works and why changes are being made. 
Moreover, they can advise other developers and QA about changes that may impact other areas of 
the code/testing.

My annoyances with version control systems lie not with the systems in general, but the specific
systems themselves. One general issue lies with "merge" operations which can be annoying or 
downright painful depending on the changes involved. And, in fact, if they're too complex, they
can be problematic. GIT, SVN, CVS, and ClearCase have all annoyed me in one way or another, but
the annoyances were specific to the tool itself.

### Docker Pros/Cons

Docker is a good deployment platform allowing applications to be isolated and yet share the same
hardware. Containers such as docker are lighter weight than full VM's allowing them to start-up
faster and have smaller footprints. And, packaging applications in containers allows them to be
more easily configured by DevOps into the larger infrastructure.

For testing, Docker ensures that the testing environment is identical to the deployment environment
nearly eliminating the possibility of issues that only appear in production. And, again due to 
their lightweight nature, they can easily be part of a continuous integration allowing for 
integration testing on every code change (even across several branches).

For development, Docker allows a developer to run the entire suite of applications on their own
machine to integrate with the application they, themselves, are working on. For complex systems
with many micro-services, this is usually easier than trying to set up a shared development
environment where engineers share the micro-services that are outside of their application. And,
again, like testing, the developer can run their code within the container to ensure their changes
will be successful in production.

### Language Choice
I would like to say that I chose Java because it was perfect for this application. But the
fact is that I simply knew I could implement it easily with Java. I knew a CSV parsing library
that would simplify reading and writing the CSV. And I knew how to easily sort any array in
Java (actually, several ways). 

But, in fact, given this problem's simplicity and lack of external interaction/dependency,
a "real" implementation would be better in a language like Rust, Go, or Python which would incur a 
small foot print and faster build. But I would have had to remember Python and learn Go/Rust. (Perl
would have also been fine, but its not sexy any more :))

## Testing Methodology

### Role for QA

I have always felt that QA should be involved in the project at the same time as the developers 
start. QA should be just an familiar with the problem domain as the developers (perhaps more so)
as well as the specification/requirements. The development of a testing plan and implementation 
needs to be scheduled out just like the development plan. It may take less time (or it may actually
take more!) but having the work scheduled ensures the overall application will be _both_ tested
and delivered on time.

In an Agile development cycle, it's also important that QA know what's being worked on in each sprint
so that they can be prepared to validate the work that's completed in each sprint. They should be 
part of the sprint acceptance criteria.

### Two Weeks

For me, I would start with the project specifications and make sure the team reviews the requirements
carefully. I would encourage questions to both flush out details from product owners and, indeed,
point out areas where the requirements are vague or unclear. I would also encourage questions of
product owners so that QA engineers become (hopefully) as familiar with the domain as the product
owners. Product owners would also need to be queried about any performance metrics that are often
left out of specifications (or are vague).

After this, I and the team would review any development plan that may exist. Based on this, we would
start our own planning process to sketch out what needs to be tested (and what doesn't), what tools
and frameworks the dev team plans to use (which may help determine what doesn't need to be tested), 
how we intend to approach testing the application, what tools we feel we need, etc. 

Once we have our plan, we need to work with the product owners and/or project manager to align our
plan with the larger project.

### When to Use Automated Testing

When it comes to API-level testing, automated testing is probably always appropriate. I really can't
imagine when it wouldn't be appropriate. And, in my opinion, most back-end applications should be
API driven and separated from their user interface (if they have one). 

For UI testing, I'll admit that I'm very unfamiliar with the state of automated UI testing. Based
on my admittedly dated knowledge, automated UI test framework were rather brittle and hard to set up.
If you have "well-understood" (older?) flows through the UI that the framework can successfully handle, 
those are good candidates in my opinion. But new part of the interface that may still be undergoing
change are likely to be better candidates for manual testing. In this case, the tester can give feedback
not only on whether the process works, but how _well_ it works and how "nice" the interface is.

### What _Not_ to Test

I think I would start by looking at what code the developers actually _did_ write/change and working
with developers to determine what needs to be tested. The developers can usually tell you which 
changes are most concerning to them and those should be prioritized. Communication and cooperation 
with the development team would be vital to determine what to test, in my opinion.

Hopefully, existing functionality already has integration testing. Refactored code would be already
covered by these tests. 

I would want to know which code is new as this is the most important work to test. I would also like
to know if any new frameworks were used in the new development. If the framework is a purchased, 
proprietary product, I would assume it has been tested. If the framework is open-source,
a review of the project can determine how well its tested. If I feel the framework is "safe", I would
likely de-prioritize testing functionality provided by that framework.

Once you have some level of prioritization on the areas to be tested, you can assign some estimates
to what it will take to test each area. From there, it's a matter of scheduling to determine what can
and cannot be tested.

And, I think its important to review with product owners what will not be tested to determine if it's
an acceptable risk.