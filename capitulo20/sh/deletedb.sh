echo '________________________________________'
echo ' '
echo 'DeleteDB  MongoDB[mongodump]'
echo ' '
echo '________________________________________'
echo 'Iniciando proceso....'
echo '      ejecutando [mongo]'
mongo
echo '      eliminano [accreditation]'
use accreditation
db.dropDataBase()
echo '      eliminano [configurationjmoordbdb]'
use configurationjmoordbdb
db.dropDataBase()
echo '      mongodump [sft]' 
use sft
db.dropDataBase()
echo 'Proceso [finalizado]'







