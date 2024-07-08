echo '________________________________________'
echo ' '
echo 'Restore de Bases de Datos MongoDB'
echo ' '
echo '________________________________________'
echo 'Iniciando proceso....'
echo '      mongorestore [accreditation]'
mongorestore --gzip --archive=accreditation.gz
echo '      mongorestore [configurationjmoordbdb]'
mongorestore --gzip --archive=configurationjmoordbdb.gz
echo '      mongorestore [sft]' 
mongorestore --gzip --archive=sft.gz

echo '      mongorestore [historydb]' 
mongorestore --gzip --archive=historydb.gz

echo '      mongorestore [transporte]' 
mongorestore --gzip --archive=transporte.gz

mongorestore --gzip --archive=autentification.gz


echo 'Proceso [finalizado]'







