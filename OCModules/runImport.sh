# OCImport runs until there's no more work then exits.

# Import config file.
IMPORT_CONFIG=./config/ocimport.properties

FILE_LIST=`find ./dist/lib -true`
CNTR="0"

for file in `echo $FILE_LIST`; do
	if [ "$CNTR" = "0" ]; then
		CNTR="1"
		CP=$file
	else
		CP=$CP:$file
	fi
done

CLASS_PATH=./:./dist/OCModules.jar:$CP

java -cp $CLASS_PATH net.filterlogic.OpenCapture.module.OCImport $IMPORT_CONFIG
