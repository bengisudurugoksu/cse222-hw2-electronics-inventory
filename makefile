all: compile run clean javadoc

compile:
	javac -d bin CSE222HW2/*.java

run:
	java -cp bin CSE222HW2.Main

clean:
	rm -rf bin/CSE222HW2/*.class

javadoc:
	javadoc -d JavaDoc CSE222HW2/*.java

.PHONY: compile run clean javadoc

