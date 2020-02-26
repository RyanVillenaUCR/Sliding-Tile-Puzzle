echo "Compiling..." \
	&& javac -d temp/ src/*.java \
	&& echo "Compiled! Running..." \
	&& java -ea -cp temp/ Driver
