
echo compiling...
echo please wait

javac -cp "src" src/linearpub/*.java
javac -cp "src" src/linkedlist/*.java

javac -cp "src:test:scorerbase.jar" test/testutil/*.java
javac -cp "src:test:scorerbase.jar" test/tests_cases/*.java

read -p "Press enter to continue"
