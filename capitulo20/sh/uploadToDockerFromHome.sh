echo '________________________________________'
echo ' '
echo 'Sube archivos desde House a Docker'
echo ' '
echo '________________________________________'
echo 'Iniciando proceso....'
echo '      subiendo [accreditation.gz]'
docker cp /home/avbravo/Descargas/accreditation.gz 198a43309fe7:/home/avbravo/accreditation.gz
echo '      subiendo [configurationjmoordbdb.gz]'
docker cp /home/avbravo/Descargas/configurationjmoordbdb.gz 198a43309fe7:/home/avbravo/configurationjmoordbdb.gz
echo '      subiendo [sft.gz]' 
docker cp /home/avbravo/Descargas/sft.gz 198a43309fe7:/home/avbravo/sft.gz

echo '      subiendo [historydb.gz]' 
docker cp /home/avbravo/Descargas/historydb.gz  198a43309fe7:/home/avbravo/historydb.gz 

echo '      subiendo [transporte.gz]' 
docker cp /home/avbravo/Descargas/transporte.gz  198a43309fe7:/home/avbravo/transporte.gz 

echo 'Proceso [finalizado]'



# docker cp /home/avbravo/Descargas/restoredb.sh 198a43309fe7:/home/avbravo/restoredb.sh
# docker cp /home/avbravo/Descargas/restoredb.sh 198a43309fe7:/home/avbravo/backup.sh

