echo "Compiling..." \
	&& test -d temp/ || mkdir temp/ \
	&& javac -d temp/ src/*.java \
	&& echo "Compiled! Running..." \
	&& java -ea -cp temp/ Driver
