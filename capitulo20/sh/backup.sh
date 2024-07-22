echo '________________________________________'
echo ' '
echo 'Backup de MongoDB[mongodump]'
echo ' '
echo '________________________________________'
echo 'Iniciando proceso....'
echo '      mongodump [accreditation]'
mongodump --archive=accreditation.gz --gzip --db=accreditation
echo '      mongodump [configurationjmoordbdb]'
mongodump --archive=configurationjmoordbdb.gz --gzip --db=configurationjmoordbdb
echo '      mongodump [sft]' 
mongodump --archive=sft.gz --gzip --db=sft

echo '      mongodump [historydb]' 
mongodump --archive=historydb.gz --gzip --db=historydb

echo '      mongodump [transporte]' 
mongodump --archive=transporte.gz --gzip --db=transporte


echo 'Proceso [finalizado]'







