
echo compiling...
echo please wait

javac -cp "src:ss_support.jar" src/pub/*.java
javac -cp "src:ss_support.jar" src/ss/*.java

javac -cp "src:test:scorerbase.jar:ss_support.jar" test/testutil/*.java
javac -cp "src:test:scorerbase.jar:ss_support.jar" test/tests_cases/*.java

read -p "Press enter to continue"
