
git clone $1
cp GradingTests.java markdown-parser/
cd markdown-parser
javac -cp lib/*:. GradingTests.java MarkdownParse.java
java -cp lib/*:. org.junit.runner.JUnitCore GradingTests
