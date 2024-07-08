echo '________________________________________'
echo ' '
echo 'Sube archivos desde Work a Docker'
echo ' '
echo '________________________________________'
echo 'Iniciando proceso....'
echo '      subiendo [accreditation.gz]'
  docker cp /home/avbravo/Descargas/accreditation.gz 21ea402673d7:/home/avbravo/accreditation.gz

  docker cp /home/avbravo/Descargas/autentification.gz 21ea402673d7:/home/avbravo/autentification.gz

echo '      subiendo [configurationjmoordbdb.gz]'
  docker cp /home/avbravo/Descargas/configurationjmoordbdb.gz 21ea402673d7:/home/avbravo/configurationjmoordbdb.gz

echo '      subiendo [sft.gz]'
 docker cp /home/avbravo/Descargas/sft.gz 21ea402673d7:/home/avbravo/sft.gz

echo '      subiendo [historydb.gz]' 
docker cp /home/avbravo/Descargas/historydb.gz  21ea402673d7:/home/avbravo/historydb.gz 

echo '      subiendo [transporte.gz]' 
docker cp /home/avbravo/Descargas/transporte.gz  21ea402673d7:/home/avbravo/transporte.gz 

echo 'Proceso [finalizado]'

 echo '      subiendo [backup.sh]' 
 docker cp /home/avbravo/Descargas/backup.sh  21ea402673d7:/home/avbravo/backup.sh

 echo '      subiendo [restore.sh]' 
docker cp /home/avbravo/Descargas/restoredb.sh 21ea402673d7:/home/avbravo/restoredb.sh

