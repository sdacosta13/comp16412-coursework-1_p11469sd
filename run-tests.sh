/usr/lib/jvm/java-11-openjdk/bin/javac -d ./chess/bin -cp .:junit-platform-console-standalone.jar ./chess/tests/*.java
/usr/lib/jvm/java-11-openjdk/bin/java -jar junit-platform-console-standalone.jar --class-path ./chess/bin --scan-class-path --fail-if-no-tests

